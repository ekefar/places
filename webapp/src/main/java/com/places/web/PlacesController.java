package com.places.web;

import com.places.service.read.PlacesReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class PlacesController {

    @Inject
    private PlacesReader placesReader;

    @RequestMapping(value = "/{country}/{city}/{page}/", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("page") int page,
                                    Map<String, Object> model) {
        final PlacesReader.PageInfo pageInfo = new PlacesReader.PageInfo(page - 1);
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
