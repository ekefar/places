package com.places.web.controller;

import com.places.service.read.LocationsReader;
import com.places.service.read.TopPlacesHelper;
import com.places.service.read.TopPlacesHelper.State;
import com.places.web.BreadcrumbsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
    private final TopPlacesHelper topPlacesHelper;

    @Inject
    public HomeController(LocationsReader locationsReader, TopPlacesHelper topPlacesHelper) {
        this.locationsReader = locationsReader;
        this.topPlacesHelper = topPlacesHelper;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        final int number = 10;
        model.put("englandTop", topPlacesHelper.topPlacesByState(State.ENGLAND, number));
        model.put("scotlandTop", topPlacesHelper.topPlacesByState(State.SCOTLAND, number));
        model.put("walesTop", topPlacesHelper.topPlacesByState(State.WALES, number));
        model.put("northernIrelandTop", topPlacesHelper.topPlacesByState(State.NORTHERN_IRELAND, number));
        return "index";
    }

    @RequestMapping(value = "/{state}/", method = RequestMethod.GET)
    public String getStatePage(@PathVariable("state") String state,
                               @RequestParam(value = "q", required = false) String startsWith,
                               Map<String, Object> model) {


        final String unURLifiedState = unURLify(state);
        final Set<String> cities = locationsReader.citiesByState(unURLifiedState, startsWith);
        model.put("topPlaces", topPlacesHelper.topPlacesByState(State.guessFromValue(unURLifiedState), 9));
        model.put("state", state);
        model.put("cities", new LinkedList(cities));
        model.put("noQuery", StringUtils.isEmpty(startsWith));
        model.put("breadcrumbs", BreadcrumbsBuilder.build(state));
        return "locations/state";
    }

    private String unURLify(String url) {
        return String.join(" ", url.split("-"));
    }


}
