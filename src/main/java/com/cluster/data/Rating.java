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

    private Integer user_id;
    private Integer rater_id;
    private Boolean rating;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRater_id() {
        return rater_id;
    }

    public void setRater_id(Integer rater_id) {
        this.rater_id = rater_id;
    }

    public Boolean getRating() {
        return rating;
    }

    public void setRating(Boolean rating) {
        this.rating = rating;
    }
}
