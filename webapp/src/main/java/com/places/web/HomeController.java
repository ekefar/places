package com.places.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Alexander Serebriyan
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "WEB-INF/views/index.html";
    }

}
