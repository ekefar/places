package com.places.service.read;

import com.places.service.read.PlacesReader.PageInfo;
import com.places.service.read.PlacesReader.PagedResult;
import com.places.service.read.dto.PlaceDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class TopPlacesHelper {

    final private PlacesReader placesReader;
    final Map<State, List<String>> topCitiesMap = prepareTopCitiesMap();

    @Inject
    public TopPlacesHelper(PlacesReader placesReader) {
        this.placesReader = placesReader;
    }

    public List<PlaceDTO> topPlacesByState(State state, int number) {
        final PageInfo pageInfo = new PageInfo(0, number);
        final PagedResult<PlaceDTO> placeDTOPagedResult = placesReader.listByState(state.value, pageInfo);
        return placeDTOPagedResult.content;
    }

    public List<String> topCitiesByState(State state, int number) {
        final List<String> cities = topCitiesMap.get(state);
        int citiesToGet = number < cities.size() ? number:cities.size();
        return cities.subList(0, citiesToGet);
    }

    private Map<State, List<String>> prepareTopCitiesMap() {
        final HashMap<State, List<String>> stateCities = new HashMap<>();
        stateCities.put(State.ENGLAND, Arrays.asList(
                "London",
                "Manchester",
                "Birmingham",
                "Leicester",
                "Liverpool",
                "Bristol",
                "Nottingham",
                "Sheffield",
                "Leeds",
                "Brighton"
        ));

        stateCities.put(State.SCOTLAND, Arrays.asList(
                "Glasgow",
                "Edinburgh",
                "Aberdeen",
                "Dundee",
                "Inverness",
                "Perth",
                "Stirling",
                "Lasswade",
                "Bellshill",
                "Midlothian"
        ));

        stateCities.put(State.WALES, Arrays.asList(
                "Cardiff",
                "Swansea",
                "Newport",
                "Bangor",
                "Chester",
                "Penarth",
                "Saint asaph",
                "Beaumaris",
                "Rhyl",
                "Menai bridge"
        ));

        stateCities.put(State.NORTHERN_IRELAND, Arrays.asList(
                "Belfast",
                "Newry",
                "Londonderry",
                "Lisburn",
                "Armagh",
                "County antrim",
                "Derry",
                "Belfast city",
                "Connswater",
                "Hillsborough"
        ));

        return stateCities;
    }

    public enum State {
        ENGLAND("England"),
        SCOTLAND("Scotland"),
        NORTHERN_IRELAND("Northern Ireland"),
        WALES("Wales");

        private String value;

        State(String value) {
            this.value = value;
        }

        public static State guessFromValue(String value) {
            final String replaced = value.replace("-", " ");
            for (State state : State.values()) {
                if(state.value.equalsIgnoreCase(value)) {
                    return state;
                }
            }

            throw new IllegalArgumentException("Can't parse state from string: " + value);
        }
    }

}
