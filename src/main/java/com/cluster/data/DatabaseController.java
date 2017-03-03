package com.cluster.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.Timestamp;
import java.sql.Time;

/**
 * Created by Fred on 2/28/17.
 */

@Controller
public class DatabaseController {

    @Autowired
    private UsersRepository usersRepository;
    private ClustersRepository clustersRepository;

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

    public boolean createUser(long id, String name, String number, String email, String fb_link, String pic_link) {
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
        u.setUp_votes(0);
        u.setDown_votes(0);

        usersRepository.save(u);
        return true;
    }

    public boolean doesClusterExist(long id) {
        Clusters cluster;
        try {
            cluster = clustersRepository.findById(id);
        }
        catch (Exception ex) {
            return false;
        }
        if (cluster == null) {
            return false;
        }
        return true;
    }

    public Clusters getCluster(long id) {
        Clusters cluster = null;
        try {
            cluster = clustersRepository.findById(id);
        }
        catch (Exception ex) {
            return cluster;
        }
        return cluster;
    }

    public long createCluster(Timestamp start, Timestamp end, long restaurant_id, String address, String city, String state, String zip, long leader_id) {

        Clusters c = new Clusters();
        c.setStart(start);
        c.setEnd(end);
        c.setRestaurant_id(restaurant_id);
        c.setAddress(address);
        c.setCity(city);
        c.setZip(zip);
        c.setState(state);
        c.setLeader_id(leader_id);

        clustersRepository.save(c);
        return c.getId();
    }
}
