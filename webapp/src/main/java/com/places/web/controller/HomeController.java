package com.places.web.controller;

import com.places.service.read.LocationsReader;
import com.places.web.BreadcrumbsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class HomeController {

    private final LocationsReader locationsReader;

    @Inject
    public HomeController(LocationsReader locationsReader) {
        this.locationsReader = locationsReader;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping(value = "/{country}/", method = RequestMethod.GET)
    public String getCountryPage(@PathVariable("country") String state,
                                 @RequestParam(value = "q", required = false) String startsWith,
                                 Map<String, Object> model) {
        final Set<String> cities = locationsReader.citiesByState(unURLify(state), startsWith);
        model.put("country", state);
        model.put("cities", new LinkedList(cities));
        model.put("breadcrumbs", BreadcrumbsBuilder.build(state));
        return "locations/country";
    }

    private String unURLify(String url) {
        return String.join(" ", url.split("-"));
    }


}
