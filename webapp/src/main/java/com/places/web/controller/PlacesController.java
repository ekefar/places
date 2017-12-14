package com.places.web.controller;

import com.places.service.read.LocationsReader;
import com.places.service.read.PlacesReader;
import com.places.service.read.PlacesReader.PageInfo;
import com.places.service.read.PlacesReader.PagedResult;
import com.places.service.read.dto.PlaceDTO;
import com.places.web.BreadcrumbsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Map;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class PlacesController {

    private final PlacesReader placesReader;
    private final LocationsReader locationsReader;

    @Inject
    public PlacesController(PlacesReader placesReader,
                            LocationsReader locationsReader) {
        this.placesReader = placesReader;
        this.locationsReader = locationsReader;
    }

    @RequestMapping(value = "/{country}/{city}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    @RequestParam(name = "page", required = false) Integer page,
                                    Map<String, Object> model) {

        int correctPage = page == null ? 0 : page - 1;
        final PageInfo pageInfo = new PageInfo(correctPage);
        final Set<String> districts = locationsReader.districtsByCity(city);
        final PagedResult<PlaceDTO> placesPage = placesReader.listByCity(city, pageInfo);
        model.put("totalItems", placesPage.totalElements);
        model.put("totalPages", placesPage.totalPages);
        model.put("currentPage", correctPage + 1);
        model.put("places", placesPage.content);
        model.put("city", city);
        model.put("country", country);
        model.put("districts", districts);
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city));
        return "places/list";
    }

    @RequestMapping(value = "/{country}/{city}/{id}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("id") String id,
                                    @PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    Map<String, Object> model) {
        final PlaceDTO place = placesReader.byId(id);

        model.put("place", place);
        model.put("photos", place.getPhotoUrls());
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city, place.getName()));
        return "places/details";
    }
}
