package com.cluster.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Fred on 2/28/17.
 */
@Entity
public class Restaurants {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;
    private String name;
    private String hb_link;
    private float rating;
    private String hours;
    private float min_delivery;
    private float delivery_fee;
    private String pic_src;
    private String address;
    private String city;
    private String state;
    private String zip;

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

    public String getHb_link() {
        return hb_link;
    }

    public void setHb_link(String hb_link) {
        this.hb_link = hb_link;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public float getMin_delivery() {
        return min_delivery;
    }

    public void setMin_delivery(float min_delivery) {
        this.min_delivery = min_delivery;
    }

    public float getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(float delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
