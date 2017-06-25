package model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * @author : Alexander Serebriyan
 */

@IgnoreExtraProperties
public class Place {

    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private Location location;
    private String openingHours;
    private String mapUrl;
    private String websiteUrl;

    private Place(String id, String name, String address, Location location, String phoneNumber,
                  String openingHours, String mapUrl, String websiteUrl) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOpeningHours() {
        return openingHours;
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

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", openingHours='" + openingHours + '\'' +
                ", mapUrl='" + mapUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                '}';
    }
}
