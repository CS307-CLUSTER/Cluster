package com.cluster.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 2/27/17.
 */
public class User {

    private long id;
    private String name;
    private Rating rating;
    private String number;
    private String fbLink;
    private String email;
    private Location location;
    private int sessionID;
    private String accessToken;
    private long currentClusterId;
    private boolean isAdmin;
    private List<User> usersToRate;

    public User(long id, String name, Rating rating, String number, String fbLink, String email, Location location, int sessionID, String accessToken) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.number = number;
        this.fbLink = fbLink;
        this.email = email;
        this.location = location;
        this.sessionID = sessionID;
        this.accessToken = accessToken;
        this.currentClusterId = -1;
        this.isAdmin = false;
        this.usersToRate = new ArrayList<>();
    }

    public void addUserToRate(User user) {
        usersToRate.add(user);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && ((User) obj).id == this.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    public long getCurrentClusterId() {
        return currentClusterId;
    }

    public void setCurrentClusterId(long currentClusterId) {
        this.currentClusterId = currentClusterId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<User> getUsersToRate() {
        return usersToRate;
    }

}
