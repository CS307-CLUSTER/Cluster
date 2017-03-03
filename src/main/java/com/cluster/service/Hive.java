package com.cluster.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shane on 2/27/17.
 */

@Component
public class Hive {

    private List<User> users;
    private List<Cluster> clusters;
    private List<Restaraunt> restaraunts;
    private int numUsers;
    private int numClusters;

    public Hive() {
        users = new ArrayList<>();
        clusters = new ArrayList<>();
        restaraunts = new ArrayList<>();
        numUsers = 0;
        numClusters = 0;
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

    public List<Restaraunt> getRestaraunts() {
        return restaraunts;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addCluster(Cluster cluster) {
        clusters.add(cluster);
    }

    public void removeClustesr(Cluster cluster) {
        clusters.remove(cluster);
    }

    public boolean clusterExists(Cluster cluster) {
        return clusters.contains(cluster);
    }

}