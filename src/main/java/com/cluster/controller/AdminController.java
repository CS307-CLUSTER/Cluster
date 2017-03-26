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
        if (user.isAdmin()) {
            return adminService.getNumActiveUsers();
        } else {
            return -1; // user was not an admin
        }
    }

    @GetMapping(path = "/getNumActiveClusters")
    public @ResponseBody int getNumActiveClusters(Principal principal) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user.isAdmin()) {
            return adminService.getNumActiveClusters();
        } else {
            return -1; // user was not an admin
        }
    }

    @GetMapping(path = "disbandCluster")
    public @ResponseBody boolean getNumActiveUsers(Principal principal, @RequestParam long clusterId) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user.isAdmin()) {
            return adminService.disbandCluster(clusterId);
        } else {
            return false;
        }
    }

    @GetMapping(path = "getUserInformation")
    public @ResponseBody User getUserInformation(Principal principal, @RequestParam int userId) {
        // verify user is admin
        User user = userService.getUserFromDatabase(Long.parseLong(principal.getName()));
        if (user.isAdmin()) {
            return adminService.getUserInformation(userId);
        } else {
            return null;
        }
    }

}

