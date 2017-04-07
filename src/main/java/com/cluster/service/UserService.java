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
    @Autowired
    private Hive hive;

    public boolean userExists(long id) {
        return databaseController.doesUserExist(id);
    }

    public boolean createUser(Principal principal, String phoneNumber, String address, String city, String state, String zip, String email) {
        // Extract details needed from Principal objesct
        HashMap userInfo = extractPrincipalDetals(principal);
        String fullName = (String) userInfo.get("name");
        String fbLink = (String) userInfo.get("link");
        long id = Long.parseLong(principal.getName());

        // Create user in database and return status
        boolean created = databaseController.createUser(id, fullName, phoneNumber, email, fbLink, null);

        if (created) {
            hive.addUser(getUserFromDatabase(id));
            return true;
        } else {
            return false;
        }
    }

    public User getUserFromDatabase(long id) {
        if (!userExists(id)) {
            return null;
        }
        // Get's a user from the database
        Users dbUser = databaseController.getUser(id);
        User user = new User(id, dbUser.getName(), null, dbUser.getNumber(), dbUser.getFb_link(), dbUser.getEmail(), null, 0, null);
        user.setRating(new Rating(dbUser.getUp_votes(), dbUser.getDown_votes()));

        return user;
    }

    public boolean isUserActive(long id) {
        for (User user: hive.getUsers()) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public User getActiveUser(long id) {
        for (User user: hive.getUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getListOfUsers() {
        return hive.getUsers();
    }

    private HashMap extractPrincipalDetals(Principal principal) {
        return (HashMap) (((OAuth2Authentication) principal).getUserAuthentication()).getDetails();
    }

    public boolean setAdmin(long id, boolean value) {
        if (isUserActive(id)) {
            getActiveUser(id).setAdmin(value);
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdmin(long id) {
        return isUserActive(id) && getActiveUser(id).isAdmin();
    }

    public boolean editInfo(long id, String name, String number, String email) {
        User user = getUserFromDatabase(id);
        if (user == null) {
            return false;
        }
        user.setName(name);
        user.setNumber(number);
        user.setEmail(email);
        return databaseController.updateUser(user);
    }

    public boolean removeRatedUser(long idOfUser, long idToRemove) {
        User user = getUserFromDatabase(idOfUser);
        User toRemove = getUserFromDatabase(idToRemove);
        if (user == null || toRemove == null) {
            return false;
        }
        return user.getUsersToRate().remove(toRemove);
    }

}
