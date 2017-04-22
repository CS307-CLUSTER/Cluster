package com.cluster.service;

import com.cluster.data.DatabaseController;
import com.cluster.data.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shane on 4/22/17.
 */

@Service
public class BackendService {

    @Autowired
    private DatabaseController databaseController;
    @Autowired
    private Hive hive;
    @Autowired
    private UserService userService;

    public void refreshRestaurants() {
        hive.clearRestaurants();
        if (databaseController.getAllRestaurant() != null) {
            for (Restaurants databaseRes : databaseController.getAllRestaurant()) {
                Location location = new Location(databaseRes.getName(), databaseRes.getAddress(), databaseRes.getCity(), databaseRes.getState(), databaseRes.getZip());
                Restaurant res = new Restaurant(databaseRes.getId(), databaseRes.getName(), databaseRes.getHb_link(), null, databaseRes.getDelivery_fee(), databaseRes.getMin_delivery(), location);
                hive.getRestaurants().add(res);
            }
        }
    }

    public void refreshUsers() {
        hive.clearUsers();
        if (databaseController.getAllUser() != null) {
            for (long id : databaseController.getAllUser()) {
                hive.getUsers().add(userService.getUserFromDatabase(id));
            }
        }
    }

}
