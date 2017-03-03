package com.cluster.service;

import com.cluster.data.DatabaseController;
import com.cluster.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shane on 3/1/17.
 */

@Controller
public class ClusterService {
    @Autowired
    private DatabaseController databaseController;
    @Autowired
    private Hive hive;
    @Autowired
    private UserService userService;

    public boolean clusterExists(long id) {
        return true;
    }

    public boolean createCluster(int maxUsers, int minUsers, long leaderID, Date startTime, Date endTime, String address, String city, String state, String zip) {
        long clusterId = databaseController.createCluster(startTime, endTime, -1, address, city, state, zip, leaderID);

        List<User> users = new ArrayList<>();
        users.add(userService.getActiveUser(leaderID));

        Cluster cluster = new Cluster(clusterId, maxUsers, minUsers, 1, users, leaderID, startTime, endTime, false, null);
        hive.addCluster(cluster);

        return true;
    }

    public boolean addUserToCluster(long userId, long clusterId) {
        User user = userService.getActiveUser(userId);
        Cluster cluster = getCluster(clusterId);

        if (user == null || cluster == null || cluster.userExists(user)) {
            return false;
        }

        user.setCurrentClusterId(clusterId);

        return cluster.addUser(user);
    }

    public boolean removeUserFromClustesr(long userId, long clusterId) {
        User user = userService.getActiveUser(userId);
        Cluster cluster = getCluster(clusterId);

        if (user == null || cluster == null || !cluster.userExists(user)) {
            return false;
        }

        user.setCurrentClusterId(-1);
        return cluster.removeUser(user);
    }

    public Cluster getCluster(long id) {
        for (Cluster cluster : hive.getClusters()) {
            if (cluster.getId() == id) {
                return cluster;
            }
        }
        return null;
    }

    public List<Cluster> getAllClusters() {
        return hive.getClusters();
    }

    public boolean addCluster() {

        return false;
    }

    public boolean removeCluster() {
        return false;
    }
}
