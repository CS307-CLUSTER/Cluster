package com.cluster.controller;

import com.cluster.service.User;
import com.cluster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


/**
 * Created by shane on 2/27/17.
 */

@RestController
@RequestMapping(path="/rating")
public class RatingController {

    @Autowired private UserService userService;

    @GetMapping(path="/getAll")
    public @ResponseBody
    List<User> getAll(Principal principal) {
        return userService.getActiveUser(Long.parseLong(principal.getName())).getUsersToRate();
    }

}
