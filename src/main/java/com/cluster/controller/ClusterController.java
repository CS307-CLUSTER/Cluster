package com.cluster.controller;

import com.cluster.service.Cluster;
import com.cluster.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrew
 */

@RestController
@RequestMapping(path="/cluster")
public class        ClusterController {

    @Autowired
    private ClusterService serviceController;

    @GetMapping(path="/create")
    public @ResponseBody String createCluster(Principal principal, @RequestParam long restaurant_id,
                                              @RequestParam int maxUsers, @RequestParam int minUsers,
                                              @RequestParam String address, @RequestParam String city,
                                              @RequestParam String state, @RequestParam String zip) {
        Date dummyDate = new Date(); // TODO remove once frontend can send dates
        long leaderId = Long.parseLong(principal.getName());
        boolean created = serviceController.createCluster(maxUsers, minUsers, leaderId, restaurant_id, dummyDate,
                dummyDate, address, city, state, zip);
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
    public @ResponseBody List<Cluster> getAllClusters() {
        // TODO Determine parameters
        return serviceController.getAllClusters();
    }

    /** Sorts alphabetically by restaurant **/
    @GetMapping(path="/getAllByRestaurant")
    public @ResponseBody List<Cluster> getAllByRestaurant() {
        return serviceController.getAllClustersByRestaurant();
    }

    @GetMapping(path="/join")
    public @ResponseBody boolean joinCluster(Principal principal, @RequestParam long clusterId) {
        return serviceController.addUserToCluster(Long.parseLong(principal.getName()), clusterId);
    }

    @GetMapping(path="/leave")
    public @ResponseBody boolean leaveCluster(Principal principal, @RequestParam long clusterId) {
        return serviceController.removeUserFromCluster(Long.parseLong(principal.getName()), clusterId);
    }

    @GetMapping(path="/getCurrent")
    public @ResponseBody Cluster getCurrentCluster(Principal principal) {
        return serviceController.getCurrentCluster(Long.parseLong(principal.getName()));
    }

    @GetMapping(path="/kick")
    public @ResponseBody boolean kickUser(Principal principal, @RequestParam long userId, @RequestParam long clusterId) {
        return serviceController.removeUserFromCluster(userId, clusterId);
    }

    @GetMapping(path="/complete")
    public @ResponseBody boolean completeCluster(Principal principal, @RequestParam long clusterId) {
        return serviceController.completeCluster(clusterId);
    }

}
