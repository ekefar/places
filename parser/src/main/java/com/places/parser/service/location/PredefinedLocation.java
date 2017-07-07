package com.places.parser.service.location;

/**
 * @author : Alexander Serebriyan
 */
public class PredefinedLocation {

    private double lat;
    private double lng;
    private int radius;
    private String name;

    public PredefinedLocation(double lat, double lng, int radius, String name) {
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PredefinedLocation{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", radius=" + radius +
                ", name='" + name + '\'' +
                '}';
    }
}
