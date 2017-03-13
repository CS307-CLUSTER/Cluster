package com.cluster.controller;

import com.cluster.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Andrew on 3/12/17.
 */
@RestController
@RequestMapping(path="admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path="/numActiveUsers")
    public @ResponseBody int getNumActiveUsers(Principal principal) {
        // verify user is admin
        return adminService.getNumActiveUsers(principal);
    }


}
