package com.cluster.controller;

import com.cluster.service.BackendService;
import com.cluster.service.Cluster;
import com.cluster.service.Hive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by shane on 4/22/17.
 */

@RestController
@RequestMapping(path="/backend")
public class BackendController {

    @Autowired
    private BackendService backendService;
    @GetMapping(path="/refresh")
    public @ResponseBody String refresh(Principal principal) {
        backendService.refreshUsers();
        backendService.refreshRestaurants();
        return "Hive refreshed";
    }

}
