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
@RequestMapping(path="admin")
public class AdminController {

    @Autowired private AdminService adminService;
    @Autowired private UserService userService;

    @GetMapping(path = "/getNumActiveUsers")
    public @ResponseBody int getNumActiveUsers(Principal principal) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user == null || !user.isAdmin()) {
            return -1; // user was not an admin
        } else {
            return adminService.getNumActiveUsers();
        }
    }

    @GetMapping(path = "/getNumActiveClusters")
    public @ResponseBody int getNumActiveClusters(Principal principal) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user == null || !user.isAdmin()) {
            return -1; // user was not an admin
        } else {
            return adminService.getNumActiveClusters();
        }
    }

    @GetMapping(path = "disbandCluster")
    public @ResponseBody boolean getNumActiveUsers(Principal principal, @RequestParam long clusterId) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user == null || !user.isAdmin()) {
            return false;
        } else {
            return adminService.disbandCluster(clusterId);
        }
    }

    @GetMapping(path = "getUserInformation")
    public @ResponseBody User getUserInformation(Principal principal, @RequestParam int userId) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user == null || !user.isAdmin()) {
            return null;
        } else {
            return adminService.getUserInformation(userId);
        }
    }

}

