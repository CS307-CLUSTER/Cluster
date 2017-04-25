package com.cluster.service;

import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by shane on 4/6/17.
 */

@Controller
public class RatingService {

    @Autowired
    private UserService userService;
    @Autowired
    private DatabaseController databaseController;

    public boolean upVoteUser(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }
        
        u.getRating().upVote();

        databaseController.updateUser(u);
        return true;
    }

    public boolean downVoteUser(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }

        u.getRating().downVote();

        databaseController.updateUser(u);
        return true;
    }

    public boolean resetRating(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }

        u.getRating().reset();

        databaseController.updateUser(u);
        return true;
    }
}
