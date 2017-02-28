package com.cluster.service;

import java.security.Principal;

/**
 * Created by shane on 2/28/17.
 */
public class ServiceController {

    public boolean userExists(long id) {
        return true;
    }

    public boolean createUser(Principal principal, String phoneNumber, String address, String city, String state, String zip) {
        return true;
    }

}
