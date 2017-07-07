package com.places.web.controller;

import com.places.service.read.LocationsReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class HomeController {

    @Inject
    private LocationsReader locationsReader;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping(value = "/{country}/", method = RequestMethod.GET)
    public String getCountryPage(@PathVariable("country") String country,
                                       Map<String, Object> model) {
        final List<String> cities = locationsReader.citiesByCountry(country);
        model.put("country", country);
        model.put("cities", cities);
        return "locations/country";
    }

}
