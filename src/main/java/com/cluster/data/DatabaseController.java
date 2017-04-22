package com.cluster.data;

import com.cluster.service.Cluster;
import com.cluster.service.Location;
import com.cluster.service.Restaurant;
import com.cluster.service.User;
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
    private RestaurantsRepository restaurantRepository;

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

    public List<Long> getAllUser() {
        List<Long> ids = new ArrayList<Long>();
        for (Users u : usersRepository.findAll()) {
            ids.add(u.getId());
        }

        return ids;
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

    public boolean updateUser(User user) {
        if (!doesUserExist(user.getId())) {
            return false;
        }

        Users u = getUser(user.getId());

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

    public List<Clusters> getAllClusters() {
        List<Clusters> clusters = new ArrayList<>();
        for (Clusters c : clustersRepository.findAll()) {
            clusters.add(c);
        }

        return clusters;
    }

    public long createCluster(Date start, Date end, long restaurant_id, Location location, long leader_id, boolean completed) {

        Clusters c = new Clusters();
        c.setStart(start);
        c.setEnd(end);
        c.setRestaurant_id(restaurant_id);
        c.setAddress(location.getAddress());
        c.setCity(location.getCity());
        c.setZip(location.getZip());
        c.setState(location.getState());
        c.setLeader_id(leader_id);
        c.setCompleted(completed);

        clustersRepository.save(c);
        return c.getId();
    }

    public boolean updateCluster(Cluster cluster) {
        if (!doesClusterExist(cluster.getId())) {
            return false;
        }

        Clusters c = getCluster(cluster.getId());

        clustersRepository.save(c);
        return true;
    }

    public boolean updateClusterOnEnd(long id, boolean completed) {
        if (!doesClusterExist(id)) {
            return false;
        }

        Clusters cluster = getCluster(id);
        cluster.setCompleted(completed);
        cluster.setEnd(new Date());

        clustersRepository.save(cluster);
        return true;
    }

    public boolean doesRestaurantExist(long id) {
        Restaurants restaurants;
        try {
            restaurants = restaurantRepository.findById(id);
        }
        catch (Exception ex) {
            return false;
        }
        if (restaurants == null) {
            return false;
        }
        return true;
    }

    public Restaurants getRestaurant(long id) {
        Restaurants restaurants = null;
        try {
            restaurants = restaurantRepository.findById(id);
        }
        catch (Exception ex) {
            return restaurants;
        }
        return restaurants;
    }

    public Iterable<Restaurants> getAllRestaurant() {

        return restaurantRepository.findAll();
    }

    public long createRestaurant(String name, String hb_link, float rating, String hours, float min_delivery, float delivery_fee, String pic_src, String address, String city, String state, String zip) {

        Restaurants r = new Restaurants();
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

    public boolean updateRestaurant(Restaurant restaurant) {
        if (!doesRestaurantExist(restaurant.getId())) {
            return false;
        }

        Restaurants r = getRestaurant(restaurant.getId());

        restaurantRepository.save(r);
        return true;
    }
}
