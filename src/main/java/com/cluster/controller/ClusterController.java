package com.cluster.controller;

import com.cluster.service.Cluster;
import com.cluster.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Andrew on 2/28/17.
 */

@RestController
@RequestMapping(path="/cluster")
public class ClusterController {

    @Autowired
    private ClusterService serviceController;

    @GetMapping(path="/create")
    public @ResponseBody String createCluster(Principal principal, @RequestParam int maxUsers,
                                              @RequestParam int minUsers, @RequestParam int leaderID,
                                              @RequestParam int startTime, @RequestParam int endTime,
                                              @RequestParam String address, @RequestParam String city,
                                              @RequestParam String state, @RequestParam String zip) {
        boolean created = serviceController.createCluster(maxUsers, minUsers, leaderID, startTime,
                endTime, address, city, state, zip);
        if (created) {
            return "Cluster created!";
        } else {
            return "Cluster failed to be created";
        }
    }

    @GetMapping(path="/info")
    public @ResponseBody Cluster clusterInfo(Principal principal, @RequestParam long id) {
        // TODO Determine parameters
        return serviceController.getCluster(id);
    }

    @GetMapping(path="/getAll")
    public @ResponseBody
    List<Cluster> getAllClusters(Principal principal, @RequestParam long id) {
        // TODO Determine parameters
        return serviceController.getAllClusters();
    }
}
