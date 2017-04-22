package com.cluster.service;

import com.cluster.data.Clusters;
import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.crypto.Data;
import java.util.List;

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
    @Autowired
    private DatabaseController databaseController;

    public int getNumActiveUsers() {
        return hive.getNumUsers();
    }

    public int getNumActiveClusters() {
        return hive.getNumClusters();
    }

    public boolean disbandCluster(long id) {
        if (clusterService.getCluster(id) != null) {
            hive.removeClusters(clusterService.getCluster(id));
            databaseController.updateClusterOnEnd(id, false);
            return true;
        } else {
            return false;
        }
    }

    public User getUserInformation(long id) {
        return userService.getUserFromDatabase(id);
    }

    public int getNumCompletedClusters() {
        int count = 0;
        for (Clusters c : databaseController.getAllClusters()) {
            if (c.isCompleted()) {
                count++;
            }
        }

        return count;
    }

    public int getNumNotCompletedClusters() {
        return databaseController.getAllClusters().size() - getNumCompletedClusters();
    }

    public List<Clusters> getAllClusterHistory() {
        return databaseController.getAllClusters();
    }
}
