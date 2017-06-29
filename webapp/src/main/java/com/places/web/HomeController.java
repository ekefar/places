package com.places.web;

import com.places.model.entity.Place;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("places", createList());

        return "places";
    }


    private List<Place> createList() {
        return newArrayList(createPlace("1"),
                createPlace("2"),
                createPlace("3"),
                createPlace("4"),
                createPlace("5"));
    }

    private Place createPlace(String id) {
        final Place place = new Place();
        place.setId(id);
        place.setAddress("London St " + id);
        place.setName("Bank 1");
        place.setPhoneNumber("123-4234-43");
        place.setOpeningHours("6:00-17:00");
        place.setMapUrl("url");
        place.setWebsiteUrl("url2");

        return place;
    }
}
