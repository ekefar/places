package com.places.web.controller;

import com.places.service.read.PlacesReader;
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

    @Inject
    private PlacesReader placesReader;

    @RequestMapping(value = "/{country}/{city}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @RequestParam(name = "page", required = false) Integer page,
                                    Map<String, Object> model) {

        int correctPage = page == null ? 0 : page - 1;
        final PlacesReader.PageInfo pageInfo = new PlacesReader.PageInfo(correctPage);
        model.put("places", placesReader.listByCity(city, pageInfo));
        return "places/list";
    }

    @RequestMapping(value = "/casino/{id}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("id") String id,
                                    Map<String, Object> model) {
        model.put("place", placesReader.byId(id));
        return "places/details";
    }
}
