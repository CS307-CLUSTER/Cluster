package com.cluster.service;

import com.cluster.data.DatabaseController;
import com.cluster.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.crypto.Data;
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

    public boolean clusterExists(long id) {
        return true;
    }

    public boolean createCluster(int maxUsers, int minUsers, int leaderID, int startTime, int endTime, Location location, String address, String city, String state, String zip) {
        return true;
    }

    public Cluster getCluster(long id) {
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
