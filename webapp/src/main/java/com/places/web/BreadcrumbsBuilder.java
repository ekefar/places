package com.places.web;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author : Alexander Serebriyan
 */
public class BreadcrumbsBuilder {

    public static List<Entry> build(Entry ... crumbs) {
        final LinkedList<Entry> result = new LinkedList<>();
        result.add(new SimpleEntry<>("Home", "/"));
        result.addAll(Arrays.asList(crumbs));
        return result;
    }

    public static List<Entry> build(String ... crumbs) {

        final Entry[] entries = new Entry[crumbs.length];

        StringBuilder link = new StringBuilder();
        for (int i = 0; i < crumbs.length; i++) {
            String crumb = crumbs[i];
            link.append(crumb.toLowerCase()).append("/");
            entries[i] = new SimpleEntry<>(crumb, link.toString());
        }

        return build(entries);
    }
}

