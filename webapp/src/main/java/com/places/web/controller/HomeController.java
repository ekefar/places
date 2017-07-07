package com.places.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping(value = "/{country}/", method = RequestMethod.GET)
    public List<String> getCountryPage(Map<String, Object> model) {
        return null;
    }

}
