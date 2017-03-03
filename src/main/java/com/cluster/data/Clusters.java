package com.cluster.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.Timestamp;

/**
 * Created by Fred on 2/28/17.
 */

@Entity
public class Clusters {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private Timestamp start;
    private Timestamp end;
    private long restaurant_id;
    private String address;
    private String city;
    private String state;
    private String zip;
    private long leader_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
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

    public long getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(long leader_id) {
        this.leader_id = leader_id;
    }
}
