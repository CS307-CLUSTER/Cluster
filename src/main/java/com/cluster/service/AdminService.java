package com.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Andrew on 3/12/17.
 */
@Controller
public class AdminService {

    @Autowired
    private Hive hive;
    @Autowired
    private ClusterService clusterService;
    @Autowired
    private UserService userService;

    public int getNumActiveUsers() {
        return hive.getNumUsers();
    }

    public int getNumActiveClusters() {
        return hive.getNumClusters();
    }

    public boolean disbandCluster(long id) {
        if (clusterService.getCluster(id) != null) {
            hive.removeClusters(clusterService.getCluster(id));
            return true;
        } else {
            return false;
        }
    }

    public User getUserInformation(long id) {
        return userService.getUserFromDatabase(id);
    }

}
