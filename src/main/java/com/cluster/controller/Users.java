package com.cluster.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by shane on 2/27/17.
 *
 * Database class for table "Users"
 *
 */

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String name;
    private Integer number;
    private String email;
    private String fb_link;
    private String pic_link;
    private Integer up_votes;
    private Integer down_votes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFb_link() {
        return fb_link;
    }

    public void setFb_link(String fb_link) {
        this.fb_link = fb_link;
    }

    public String getPic_link() {
        return pic_link;
    }

    public void setPic_link(String pic_link) {
        this.pic_link = pic_link;
    }

    public Integer getUp_votes() {
        return up_votes;
    }

    public void setUp_votes(Integer up_votes) {
        this.up_votes = up_votes;
    }

    public Integer getDown_votes() {
        return down_votes;
    }

    public void setDown_votes(Integer down_votes) {
        this.down_votes = down_votes;
    }
}
