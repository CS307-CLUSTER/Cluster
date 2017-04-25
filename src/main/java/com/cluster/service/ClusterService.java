package com.cluster.service;

import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
    @Autowired
    private RestaurantService restaurantService;

    public boolean clusterExists(long id) {
        return true;
    }

    public boolean createCluster(int maxUsers, int minUsers, long leaderID, long restaurantId, Date startTime, Date endTime, String address, String city, String state, String zip) {
        Location location = new Location("", address, city, state, zip);
        long clusterId = databaseController.createCluster(startTime, endTime, -1, location, leaderID, false, restaurantService.getRestaurant(restaurantId).getName(), userService.getActiveUser(leaderID).getName());

        List<User> users = new ArrayList<>();
        User user = userService.getActiveUser(leaderID);
        users.add(user);
        user.setCurrentClusterId(clusterId);



        Cluster cluster = new Cluster(clusterId, maxUsers, minUsers, 1, restaurantService.getRestaurant(restaurantId), users, leaderID, startTime, endTime, false, location);
        hive.addCluster(cluster);

        return true;
    }

    public boolean addUserToCluster(long userId, long clusterId) {
        User user = userService.getActiveUser(userId);
        Cluster cluster = getCluster(clusterId);

        if (user == null || cluster == null || cluster.userExists(user) || user.getCurrentClusterId() != -1) {
            return false;
        }

        user.setCurrentClusterId(clusterId);

        return cluster.addUser(user);
    }

    public boolean removeUserFromCluster(long userId, long clusterId) {
        User user = userService.getActiveUser(userId);
        Cluster cluster = getCluster(clusterId);

        if (user == null || cluster == null || !cluster.userExists(user)) {
            return false;
        }

        user.setCurrentClusterId(-1);
        return cluster.removeUser(user);
    }

    public Cluster getCurrentCluster(long userId) {
        User user = userService.getActiveUser(userId);
        if (user == null) {
            return null;
        }

        Cluster cluster = getCluster(user.getCurrentClusterId());
        return cluster;
    }

    public Cluster getCluster(long id) {
        for (Cluster cluster : hive.getClusters()) {
            if (cluster.getId() == id) {
                return cluster;
            }
        }
        return null;
    }

    public boolean completeCluster(long clusterId) {
        Cluster cluster = getCluster(clusterId);
        cluster.setComplete(true);

        for (User u : cluster.getUsers()) {
            for (User u2 : cluster.getUsers()) {
                if (!u2.equals(u)) {
                    u.addUserToRate(u2);
                }
            }
            u.setCurrentClusterId(-1);
        }


        databaseController.updateClusterOnEnd(clusterId, true);
        hive.removeClusters(cluster);

        return true;
    }

    public List<Cluster> getAllClusters() {
        List<Cluster> clusters = hive.getClusters();
        clusters.sort(new NewestComparator());
        return clusters;
    }

    public List<Cluster> getAllClustersByRestaurant() {
        List<Cluster> clusters = hive.getClusters();
        clusters.sort(new RestaurantComparator());
        return clusters;
    }

    private class NewestComparator implements Comparator<Cluster> {
        @Override
        public int compare (Cluster a, Cluster b) {
            return a.getId() > b.getId() ? -1 : a.getId() == b.getId() ? 0 : 1;
        }
    }

    private class RestaurantComparator implements Comparator<Cluster> {
        @Override
        public int compare(Cluster a, Cluster b) {
            return a.getRestaurant().getName().compareTo(b.getRestaurant().getName());
        }
    }

    public boolean addCluster() {
        return false;
    }

    public boolean removeCluster() {
        return false;
    }
}
