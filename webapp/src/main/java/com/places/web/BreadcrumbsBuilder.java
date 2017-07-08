package com.places.web;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class BreadcrumbsBuilder {

    public static List<String> build(String ... crumbs) {
        final LinkedList<String> result = new LinkedList<>();
        result.add("Home");
        result.addAll(Arrays.asList(crumbs));
        return result;
    }

}
