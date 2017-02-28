package com.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by shane on 2/27/17.
*/

@RestController
@RequestMapping(path="/user")
public class UserController {

    @GetMapping(path="/test")
    public @ResponseBody String test() {
        return "Test successful!!!!!!!!!!!!!!!!";
    }

    @GetMapping(path="/login")
    public @ResponseBody  String login(Principal principal) {
        return principal.getName();
    }

    @GetMapping(path="/userInfo")
    public @ResponseBody Principal userInfo(Principal principal) {
        return principal;
    }

}
