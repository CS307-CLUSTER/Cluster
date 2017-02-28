package com.cluster.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Fred on 2/28/17.
 */

@Controller
public class DatabaseController {

    @Autowired
    private UsersRepository usersRepository;

    //Takes in a User id and returns true if user exists, and false otherwise
    public boolean doesUserExist(long id) {
        Users user = null;
        try {
            user = usersRepository.findById(id);
        }
        catch (Exception ex) {
            return false;
        }
        if (user == null) {
            return false;
        }
        return true;
    }

    public Users getUser(long id) {
        Users user = null;
        try {
            user = usersRepository.findById(id);
        }
        catch (Exception ex) {
            return user;
        }
        return user;
    }

    public boolean createUser(long id, String name, String number, String email, String fb_link, String pic_link, int up_votes, int down_votes) {
        if (doesUserExist(id)) {
            return false;
        }

        Users u = new Users();
        u.setId(id);
        u.setName(name);
        u.setNumber(number);
        u.setEmail(email);
        u.setFb_link(fb_link);
        u.setPic_link(pic_link);
        u.setUp_votes(up_votes);
        u.setDown_votes(down_votes);

        return true;
    }
}
