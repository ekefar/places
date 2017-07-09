package com.places.model.entity;

/**
 * @author : Alexander Serebriyan
 */
public class Photo {
    private String reference;
    private int width;
    private int height;

    public Photo() {
    }

    public Photo(String reference, int width, int height) {
        this.reference = reference;
        this.width = width;
        this.height = height;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "reference='" + reference + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
