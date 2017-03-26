package com.cluster.service;

/**
 * Created by shane on 2/27/17.
 */
public class Restaurant {

    //TODO: still need to add a way to show hours

    private int id;
    private String name;
    private String hungryBoilerLink;
    private Rating rating;
    private double deliveryFee;
    private double deliveryMinimum;
    private Location location;

    public Restaurant(int id, String name, String hungryBoilerLink, Rating rating, double deliveryFee, double deliveryMinimum, Location location) {
        this.id = id;
        this.name = name;
        this.hungryBoilerLink = hungryBoilerLink;
        this.rating = rating;
        this.deliveryFee = deliveryFee;
        this.deliveryMinimum = deliveryMinimum;
        this.location = location;
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

    public String getHungryBoilerLink() {
        return hungryBoilerLink;
    }

    public void setHungryBoilerLink(String hungryBoilerLink) {
        this.hungryBoilerLink = hungryBoilerLink;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getDeliveryMinimum() {
        return deliveryMinimum;
    }

    public void setDeliveryMinimum(double deliveryMinimum) {
        this.deliveryMinimum = deliveryMinimum;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
