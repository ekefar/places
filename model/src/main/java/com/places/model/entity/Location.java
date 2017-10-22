package com.places.model.entity;

/**
 * @author : Alexander Serebriyan
 */
public class Location {

    private double lat;
    private double lng;
    private int radius;

    public Location() {
    }

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Location(double lat, double lng, int radius) {
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
