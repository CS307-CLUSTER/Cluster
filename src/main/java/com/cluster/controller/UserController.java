package com.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shane on 2/27/17.
*/

@Controller
@RequestMapping(path="/user")
public class UserController {

    @GetMapping(path="/test")
    public @ResponseBody String test() {
        return "Test successful!!!!!!!!!!!!!!!!";
    }

}
