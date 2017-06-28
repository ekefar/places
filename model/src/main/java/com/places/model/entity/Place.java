package com.places.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : Alexander Serebriyan
 */

@Document(collection = "places")
public class Place {

    @Id
    private String id;
    private String mapsId;
    private String name;
    private String address;
    private String phoneNumber;
    private Location location;
    private String openingHours;
    private String mapUrl;
    private String websiteUrl;

    public Place() {
    }

    private Place(String mapsId, String name, String address, Location location, String phoneNumber,
                  String openingHours, String mapUrl, String websiteUrl) {
        this.mapsId = mapsId;
        this.name = name;
        this.address = address;
        this.location = location;
        this.openingHours = openingHours;
        this.mapUrl = mapUrl;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", mapsId='" + mapsId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", openingHours='" + openingHours + '\'' +
                ", mapUrl='" + mapUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                '}';
    }

    public enum Type {
        BANK
    }

    public static class Builder {
        private String id;
        private String name;
        private String address;
        private String phoneNumber;
        private Location location;
        private String openingHours;
        private String mapUrl;
        private String websiteUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
            return this;
        }

        public Builder setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }

        public Builder setOpeningHours(String openingHours) {
            this.openingHours = openingHours;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Place build() {
            return new Place(id, name, address, location, phoneNumber, openingHours, mapUrl, websiteUrl);
        }
    }

}
