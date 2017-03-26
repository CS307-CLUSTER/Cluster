package com.cluster.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fred on 2/28/17.
 */

@Controller
public class DatabaseController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ClustersRepository clustersRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

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

    public Iterable<Users> getAllUser() {
        return usersRepository.findAll();
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

    public boolean updateUser(Users users) {
        if (doesUserExist(users.getId())) {
            return false;
        }

        Users u = getUser(users.getId());

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

    public Iterable<Clusters> getAllCluster() {
        return clustersRepository.findAll();
    }

    public long createCluster(Date start, Date end, long restaurant_id, String address, String city, String state, String zip, long leader_id) {

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

    public Restaurant getRestaurant(long id) {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantRepository.findById(id);
        }
        catch (Exception ex) {
            return restaurant;
        }
        return restaurant;
    }

    public Iterable<Restaurant> getAllRestaurant() {

        return restaurantRepository.findAll();
    }

    public long createRestaurant(long id, String name, String hb_link, float rating, String hours, float min_delivery, float delivery_fee, String pic_src, String address, String city, String state, String zip) {

        Restaurant r = new Restaurant();
        r.setId(id);
        r.setName(name);
        r.setHb_link(hb_link);
        r.setRating(rating);
        r.setHours(hours);
        r.setMin_delivery(min_delivery);
        r.setDelivery_fee(delivery_fee);
        r.setPic_src(pic_src);
        r.setAddress(address);
        r.setCity(city);
        r.setState(state);
        r.setZip(zip);

        restaurantRepository.save(r);
        return r.getId();
    }
}
