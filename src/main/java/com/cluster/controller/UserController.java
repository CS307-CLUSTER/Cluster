package com.cluster.controller;

import com.cluster.service.RatingService;
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

    @Autowired private UserService userService;
    @Autowired private RatingService ratingService;

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

    @GetMapping(path="/getId")
    public @ResponseBody long getId(Principal principal) {
        return userInfo(principal).getId();
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
                                           @RequestParam String zip, @RequestParam String address,
                                           @RequestParam String email) {
        boolean created = userService.createUser(principal, phoneNumber, address, city, state, zip, email);
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

    @GetMapping(path="/exists")
    public @ResponseBody boolean doesUserExist(Principal principal) {
        return userService.userExists(Long.parseLong(principal.getName()));
    }

    @GetMapping(path="/makeAdmin")
    public @ResponseBody boolean makeUserAdmin(Principal principal, @RequestParam long userId) {
        return userService.isUserActive(userId) && userService.setAdmin(userId, true);
    }

    @GetMapping(path="/removeAdmin")
    public @ResponseBody boolean removeAdmin(Principal principal, @RequestParam long userId) {
        return userService.isUserActive(userId) && userService.setAdmin(userId, false);
    }

    @GetMapping(path="/isAdmin")
    public @ResponseBody boolean isAdmin(Principal principal) {
        return userService.isAdmin(Long.parseLong(principal.getName()));
    }

    @GetMapping(path="/upVote")
    public @ResponseBody boolean upVote(Principal principal, @RequestParam long userId) {
        return ratingService.upVoteUser(userId);
    }

    @GetMapping(path="/downVote")
    public @ResponseBody boolean downVote(Principal principal, @RequestParam long userId) {
        return ratingService.downVoteUser(userId);
    }

}
