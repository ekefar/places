package com.places.web.controller;

import com.places.service.read.LocationsReader;
import com.places.web.BreadcrumbsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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
        final Set<String> cities = locationsReader.citiesByCountry(country);
        model.put("country", country);
        model.put("cities", new LinkedList(cities));
        model.put("breadcrumbs", BreadcrumbsBuilder.build(country));
        return "locations/country";
    }



}
