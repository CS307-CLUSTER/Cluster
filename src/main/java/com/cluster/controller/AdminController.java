package com.cluster.controller;

import com.cluster.service.AdminService;
import com.cluster.service.User;
import com.cluster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Andrew
 */
@RestController
@RequestMapping(path="/admin")
public class AdminController {

    @Autowired private AdminService adminService;
    @Autowired private UserService userService;

    @GetMapping(path = "/getNumActiveUsers")
    public @ResponseBody int getNumActiveUsers(Principal principal) {
        // verify user is admin
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.getNumActiveUsers();
        }
        return -1; // user was not an admin`
    }

    @GetMapping(path = "/getNumActiveClusters")
    public @ResponseBody int getNumActiveClusters(Principal principal) {
        // verify user is admin
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.getNumActiveClusters();
        }
        return -1; // user was not an admin
    }

    @GetMapping(path = "/disbandCluster")
    public @ResponseBody boolean getNumActiveUsers(Principal principal, @RequestParam long clusterId) {
        // verify user is admin
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.disbandCluster(clusterId);
        }
        return false;
    }

    @GetMapping(path = "/getUserInformation")
    public @ResponseBody User getUserInformation(Principal principal, @RequestParam long userId) {
        // verify user is admin
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.getUserInformation(userId);
        }
        return null;
    }

    @GetMapping(path = "/getNumCompletedOrders")
    public @ResponseBody int getNumCompletedOrders(Principal principal) {
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.getNumCompletedClusters();
        }
        return -1;
    }

    @GetMapping(path = "/getNumNotCompletedOrders")
    public @ResponseBody int getNumNotCompletedOrders(Principal principal) {
        if (userService.isAdmin(Long.parseLong(principal.getName()))) {
            return adminService.getNumNotCompletedClusters();
        }
        return -1;
    }

}

