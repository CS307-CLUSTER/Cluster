package com.cluster.controller;

import com.cluster.service.User;
import com.cluster.service.UserServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;

/**
 * Created by shane on 2/27/17.
*/

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserServiceController userServiceController;

    @GetMapping(path="/test")
    public @ResponseBody String test(Principal principal) {
        HashMap userInfo = (HashMap) (((OAuth2Authentication) principal).getUserAuthentication()).getDetails();
        userInfo.get("first_name");

        return (String) userInfo    .get("first_name");
    }

    @GetMapping(path="/login")
    public @ResponseBody  String login(Principal principal) {
        return principal.getName();
    }

    @GetMapping(path="/info")
    public @ResponseBody User userInfo(Principal principal) {
        return userServiceController.getUser(Long.parseLong(principal.getName()));
    }

    @GetMapping(path="/check")
    public @ResponseBody String checkUser(Principal principal) {
        if (userServiceController.userExists(Long.parseLong(principal.getName()))) {
            return "User exists";
        } else {
            return "User does not exist";
        }
    }

    @GetMapping(path="/create")
    public @ResponseBody String createUser(Principal principal, @RequestParam String phoneNumber,
                                           @RequestParam String city, @RequestParam String state,
                                           @RequestParam String zip, @RequestParam String address) {
        boolean created = userServiceController.createUser(principal, phoneNumber, address, city, state, zip);
        if (created) {
            return "User " + principal.getName() + " has been created";
        } else {
            return "User " + principal.getName() + " failed to be created";
        }
    }

}
