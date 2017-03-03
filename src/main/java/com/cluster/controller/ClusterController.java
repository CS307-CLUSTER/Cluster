package com.cluster.controller;

import com.cluster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrew on 2/28/17.
 */

@RestController
@RequestMapping(path="/cluster")
public class ClusterController {

    @Autowired
    private UserService serviceController;

    @GetMapping(path="/create")
    public @ResponseBody String createCluster() {
        // TODO Determine parameters from frontend
        // TODO Implement creation from serviceController it has been implemented by @ShaneLi
        return "Cluster creation reached"; // temporary dummy response
    }

    @GetMapping(path="/info")
    public @ResponseBody String clusterInfo() {
        // TODO Determine parameters
        return "Cluster information reached"; // temporary dummy response
    }
}
