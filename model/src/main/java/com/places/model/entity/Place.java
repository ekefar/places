package com.places.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */

@Document(collection = "places")
public class Place {

    @Id
    private String id;
    private String country;
    private String city;

    // google maps specific
    private String mapsId;
    private String name;
    private String address;
    private String phoneNumber;
    private Location location;
    private String openingHours;
    private String mapUrl;
    private String websiteUrl;
    private float rating;
    private List<String> type = new LinkedList<>();
    private List<String> photos = new LinkedList<>();
    private List<Review> reviews = new LinkedList<>();


    public Place() {
    }

    public Place(String id, String country, String city, String mapsId, String name, String address,
                 String phoneNumber, Location location, String openingHours, String mapUrl, String websiteUrl,
                 float rating) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.mapsId = mapsId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.openingHours = openingHours;
        this.mapUrl = mapUrl;
        this.websiteUrl = websiteUrl;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMapsId() {
        return mapsId;
    }

    public void setMapsId(String mapsId) {
        this.mapsId = mapsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", mapsId='" + mapsId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", openingHours='" + openingHours + '\'' +
                ", mapUrl='" + mapUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", rating=" + rating +
                ", type=" + type +
                ", photos=" + photos +
                ", reviews=" + reviews +
                '}';
    }

    public enum Type {
        BANK
    }

}
