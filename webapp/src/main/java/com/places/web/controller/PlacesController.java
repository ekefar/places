package com.places.web.controller;

import com.places.model.entity.Place;
import com.places.service.read.PlacesReader;
import com.places.service.read.PlacesReader.PageInfo;
import com.places.web.BreadcrumbsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class PlacesController {

    private final PlacesReader placesReader;

    @Inject
    public PlacesController(PlacesReader placesReader) {
        this.placesReader = placesReader;
    }

    @RequestMapping(value = "/{country}/{city}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    @RequestParam(name = "page", required = false) Integer page,
                                    Map<String, Object> model) {

        int correctPage = page == null ? 0 : page - 1;
        final PageInfo pageInfo = new PageInfo(correctPage);
        final Page<Place> placesPage = placesReader.listByCity(city, pageInfo);
        model.put("total", placesPage.getTotalElements());
        model.put("page", page);
        model.put("places", placesPage.getContent());
        model.put("city", city);
        model.put("country", country);
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city));
        return "places/list";
    }

    @RequestMapping(value = "/{country}/{city}/{id}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("id") String id,
                                    @PathVariable("city") String city,
                                    @PathVariable("country") String country,
                                    Map<String, Object> model) {
        final Place place = placesReader.byId(id);
        model.put("place", place);
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country, city, place.getName()));
        return "places/details";
    }
}
