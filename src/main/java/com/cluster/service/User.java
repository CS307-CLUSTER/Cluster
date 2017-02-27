package com.cluster.service;

/**
 * Created by shane on 2/27/17.
 */
public class User {

    private int id;
    private String name;
    private Rating rating;
    private int number;
    private String fbLink;
    private String email;
    private Location location;
    private int sessionID;
    private String accessToken;

    public User(int id, String name, Rating rating, int number, String fbLink, String email, Location location, int sessionID, String accessToken) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.number = number;
        this.fbLink = fbLink;
        this.email = email;
        this.location = location;
        this.sessionID = sessionID;
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
