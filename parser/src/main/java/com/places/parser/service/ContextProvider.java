package com.places.parser.service;

import com.google.maps.GeoApiContext;

/**
 * @author : Alexander Serebriyan
 */
public class ContextProvider {

    private static final String KEY = "AIzaSyByY27K_qk6NEZ5L2w8WssBh5BiMp-XbHY";

    private static final GeoApiContext GEO_CONTEXT = createGeoContext();

    private static GeoApiContext createGeoContext() {
        return new GeoApiContext().setApiKey(KEY);
    }

    public static GeoApiContext getGeoContext() {
        return GEO_CONTEXT;
    }
}
