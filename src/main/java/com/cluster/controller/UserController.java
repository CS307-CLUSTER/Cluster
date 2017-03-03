package com.cluster.controller;

import com.cluster.service.User;
import com.cluster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by shane on 2/27/17.
*/

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/test")
    public @ResponseBody Principal test(Principal principal) {
        return principal;
    }

    @GetMapping(path="/login")
    public @ResponseBody  String login(Principal principal) {
        return principal.getName();
    }

    @GetMapping(path="/info")
    public @ResponseBody User userInfo(Principal principal) {
        return userService.getActiveUser(Long.parseLong(principal.getName()));
    }

    @GetMapping(path="/check")
    public @ResponseBody String checkUser(Principal principal) {
        if (userService.userExists(Long.parseLong(principal.getName()))) {
            return "User exists";
        } else {
            return "User does not exist";
        }
    }

    @GetMapping(path="/create")
    public @ResponseBody String createUser(Principal principal, @RequestParam String phoneNumber,
                                           @RequestParam String city, @RequestParam String state,
                                           @RequestParam String zip, @RequestParam String address) {
        boolean created = userService.createUser(principal, phoneNumber, address, city, state, zip);
        if (created) {
            return "User " + principal.getName() + " has been created";
        } else {
            return "User " + principal.getName() + " failed to be created";
        }
    }

    @GetMapping(path="/getAll")
    public @ResponseBody List<User> getAllUsers() {
        return userService.getListOfUsers();
    }

}
