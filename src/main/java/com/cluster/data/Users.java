package com.cluster.data;

import javax.persistence.*;

/**
 * Created by shane on 2/27/17.
 * <p>
 * Database class for table "Users"
 */

@Entity
public class Users {

    @Id
    private long id;
    private String name;
    private String number;
    private String email;
    private String fb_link;
    private String pic_link;
    private int up_votes;
    private int down_votes;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    public int getUp_votes() {
        return up_votes;
    }

    public void setUp_votes(int up_votes) {
        this.up_votes = up_votes;
    }

    public int getDown_votes() {
        return down_votes;
    }

    public void setDown_votes(int down_votes) {
        this.down_votes = down_votes;
    }
}
