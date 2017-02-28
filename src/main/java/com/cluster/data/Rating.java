package com.cluster.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Created by Fred on 2/28/17.
 */

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long user_id;
    private long rater_id;
    private boolean rating;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getRater_id() {
        return rater_id;
    }

    public void setRater_id(long rater_id) {
        this.rater_id = rater_id;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}
