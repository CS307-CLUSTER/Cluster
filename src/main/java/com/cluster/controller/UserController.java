package com.cluster.controller;

import com.cluster.service.ServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by shane on 2/27/17.
*/

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private ServiceController serviceController;

    @GetMapping(path="/test")
    public @ResponseBody String test() {
        return "Test successful!!!!!!!!!!!!!!!!";
    }

    @GetMapping(path="/login")
    public @ResponseBody  String login(Principal principal) {
        return principal.getName();
    }

    @GetMapping(path="/info")
    public @ResponseBody Principal userInfo(Principal principal) {
        return principal;
    }

    @GetMapping(path="/check")
    public @ResponseBody String checkUser(Principal principal) {
        if (serviceController.userExists(Long.parseLong(principal.getName()))) {
            return "User exists";
        } else {
            return "User does not exist";
        }
    }

    @GetMapping(path="/create")
    public @ResponseBody String createUser(Principal principal, @RequestParam String phoneNumber,
                                           @RequestParam String city, @RequestParam String state,
                                           @RequestParam String zip, @RequestParam String address) {
        boolean created = serviceController.createUser(principal, phoneNumber, address, city, state, zip);
        if (created) {
            return "User " + principal.getName() + " has been created";
        } else {
            return "User " + principal.getName() + " failed to be created";
        }
    }

}
