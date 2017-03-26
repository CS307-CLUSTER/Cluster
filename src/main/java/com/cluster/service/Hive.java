package com.cluster.service;

import com.cluster.data.DatabaseController;
import com.cluster.data.Restaurants;
import com.cluster.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 2/27/17.
 */

@Component
public class Hive {

    @Autowired
    private DatabaseController databaseController;
    @Autowired
    private UserService userService;
    private List<User> users;
    private List<Cluster> clusters;
    private List<com.cluster.service.Restaurant> restaraunts;
    private int numUsers;
    private int numClusters;

    public Hive() {
        users = new ArrayList<>();
        clusters = new ArrayList<>();
        restaraunts = new ArrayList<>();
        numUsers = 0;
        numClusters = 0;

        refreshRestaurants();
        refreshUsers();
    }


    public int getNumUsers() {
        return numUsers;
    }

    public int getNumClusters() {
        return numClusters;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public List<com.cluster.service.Restaurant> getRestaraunts() {
        return restaraunts;
    }

    public void addUser(User user) {
        users.add(user);
        numUsers++;
    }

    public void removeUser(User user) {
        users.remove(user);
        numUsers--;
    }

    public void addCluster(Cluster cluster) {
        clusters.add(cluster);
        numClusters++;
    }

    public void removeClustesr(Cluster cluster) {
        clusters.remove(cluster);
        numClusters--;
    }

    public boolean clusterExists(Cluster cluster) {
        return clusters.contains(cluster);
    }

    public void refreshRestaurants() {
        restaraunts.clear();
        for (Restaurants databaseRes : databaseController.getAllRestaurant()) {
            Restaurant res = new Restaurant(databaseRes.getId(), databaseRes.getName(), databaseRes.getHb_link(), null, databaseRes.getDelivery_fee(), databaseRes.getMin_delivery(), null);
            restaraunts.add(res);
        }
    }

    public void refreshUsers() {
        users.clear();
        for (long id : databaseController.getAllUser()) {
            users.add(userService.getUserFromDatabase(id));
        }
    }

}