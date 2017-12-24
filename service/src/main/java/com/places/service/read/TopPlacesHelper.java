package com.places.service.read;

import com.places.service.read.PlacesReader.PageInfo;
import com.places.service.read.PlacesReader.PagedResult;
import com.places.service.read.dto.PlaceDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class TopPlacesHelper {

    final private PlacesReader placesReader;

    @Inject
    public TopPlacesHelper(PlacesReader placesReader) {
        this.placesReader = placesReader;
    }

    public List<PlaceDTO> topPlacesByState(State state, int number) {
        final PageInfo pageInfo = new PageInfo(0, number);
        final PagedResult<PlaceDTO> placeDTOPagedResult = placesReader.listByState(state.value, pageInfo);
        return placeDTOPagedResult.content;
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
