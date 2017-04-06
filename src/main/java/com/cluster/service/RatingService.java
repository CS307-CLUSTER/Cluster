package com.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by shane on 4/6/17.
 */

@Controller
public class RatingService {

    @Autowired
    private UserService userService;

    public boolean upVoteUser(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }
        
        u.getRating().upVote();
        return true;
    }

    public boolean downVoteUser(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }

        u.getRating().downVote();
        return true;
    }

    public boolean resetRating(long id) {
        User u = userService.getActiveUser(id);

        if (u == null) {
            return false;
        }

        u.getRating().reset();
        return true;
    }
}
