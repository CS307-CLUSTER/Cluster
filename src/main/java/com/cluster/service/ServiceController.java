package com.cluster.service;

import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by shane on 2/28/17.
 */

@Controller
public class ServiceController {
    @Autowired
    private DatabaseController databaseController;

    public boolean userExists(long id) {
        return databaseController.doesUserExist(id);
    }

    public boolean createUser(Principal principal, String phoneNumber, String address, String city, String state, String zip) {
        return true;
    }

}
