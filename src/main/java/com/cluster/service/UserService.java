package com.cluster.service;

import com.cluster.data.DatabaseController;
import com.cluster.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shane on 2/28/17.
 */

@Controller
public class UserService {
    @Autowired
    private DatabaseController databaseController;
    private Hive hive;

    public boolean userExists(long id) {
        return databaseController.doesUserExist(id);
    }

    public boolean createUser(Principal principal, String phoneNumber, String address, String city, String state, String zip) {
        // Extract details needed from Principal object
        HashMap userInfo = extractPrincipalDetals(principal);
        String fullName = (String) userInfo.get("name");
        String fbLink = (String) userInfo.get("link");

        // Create user in database and return status
        return databaseController.createUser(Long.parseLong(principal.getName()), fullName, phoneNumber, null, fbLink, null);
    }

    public User getUser(long id) {
        // Get's a user from the database
        Users dbUser = databaseController.getUser(id);
        User user = new User(id, dbUser.getName(), null, dbUser.getNumber(), dbUser.getFb_link(), dbUser.getEmail(), null, 0, null);
        user.setRating(new Rating(dbUser.getUp_votes(), dbUser.getDown_votes()));
        return user;
    }

    public List<User> getListOfUsers() {
        return hive.getUsers();
    }

    private HashMap extractPrincipalDetals(Principal principal) {
        return (HashMap) (((OAuth2Authentication) principal).getUserAuthentication()).getDetails();
    }

}
