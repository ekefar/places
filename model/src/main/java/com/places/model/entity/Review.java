package com.places.model.entity;

import java.util.Date;

/**
 * @author : Alexander Serebriyan
 */
public class Review {
    private String authorName;
    private String authorUrl;
    private String language;
    private float rating;
    private String text;
    private Date date;

    public Review() {
    }

    public Review(String authorName, String authorUrl, String language, float rating, String text, Date date) {
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.language = language;
        this.rating = rating;
        this.text = text;
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
