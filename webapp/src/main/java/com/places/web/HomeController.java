package com.places.web;

import com.places.service.read.PlacesReader;
import com.places.service.read.PlacesReader.PageInfo;
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
public class HomeController {

    @Inject
    private PlacesReader placesReader;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("places", placesReader.list());

        return "places";
    }

    @RequestMapping(value = "/{country}/{city}/{page}", method = RequestMethod.GET)
    public String placesByCityPaged(@PathVariable("city") String city,
                                    @PathVariable("page") int page,
                                    Map<String, Object> model) {

        final PageInfo pageInfo = new PageInfo(page - 1);
        model.put("places", placesReader.listByCity(city, pageInfo));
        return "places";
    }


}
