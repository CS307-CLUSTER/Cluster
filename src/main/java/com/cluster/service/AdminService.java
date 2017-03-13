package com.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by Andrew on 3/12/17.
 */
@Controller
public class AdminService {

    @Autowired
    private Hive hive;

    public int getNumActiveUsers(Principal principal) {
        /** TODO Keep track of active users in Hive **/
        return hive.getNumUsers();
    }

}
