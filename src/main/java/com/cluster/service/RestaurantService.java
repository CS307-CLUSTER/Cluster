package com.cluster.service;

import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by shane on 3/25/17.
 */

@Controller
public class RestaurantService {

    @Autowired
    private DatabaseController databaseController;
    @Autowired
    private Hive hive;

    public boolean addRestaurant(long id, String name, String hb_link, float rating, String hours, float min_delivery, float delivery_fee, String pic_src, String address, String city, String state, String zip) {
        if (!restaurantExists(name)) {
            return false;
        }

        databaseController.createRestaurant(id, name, hb_link, rating, hours, min_delivery, delivery_fee, pic_src, address, city, state, zip);
        hive.refreshRestaurants();
        return true;
    }

    public boolean restaurantExists(long id) {
        for (Restaurant res : hive.getRestaraunts()) {
            if (res.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean restaurantExists(String name) {
        for (Restaurant res : hive.getRestaraunts()) {
            if (res.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Restaurant getRestaurant(long id) {
        if (restaurantExists(id)) {
            for (Restaurant res : hive.getRestaraunts()) {
                if (res.getId() == id) {
                    return res;
                }
            }
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return hive.getRestaraunts();
    }

}
