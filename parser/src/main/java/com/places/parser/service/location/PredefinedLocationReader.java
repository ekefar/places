package com.places.parser.service.location;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class PredefinedLocationReader {


    public static final String LOCATIONS_LIST = "locations.json";

    public static List<PredefinedLocation> read() {
        URL url = Resources.getResource(LOCATIONS_LIST);
        try {
            String text = Resources.toString(url, Charsets.UTF_8);
            Type listType = new TypeToken<ArrayList<PredefinedLocation>>(){}.getType();
            List<PredefinedLocation> locations = new Gson().fromJson(text, listType);
            return locations;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
