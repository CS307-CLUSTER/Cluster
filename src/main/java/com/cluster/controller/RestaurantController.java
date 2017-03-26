package com.cluster.controller;

import com.cluster.service.Restaurant;
import com.cluster.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Andrew
 */
@RestController
@RequestMapping(path="/restaurant")
public class RestaurantController {

    @Autowired private RestaurantService restaurantService;

    @GetMapping(path="/add")
    public @ResponseBody boolean addRestaurant(Principal principal,
                                               @RequestParam long id, @RequestParam String name,
                                               @RequestParam String hb_link, @RequestParam float rating,
                                               @RequestParam String hours, @RequestParam float min_delivery,
                                               @RequestParam float delivery_fee, @RequestParam String pic_src,
                                               @RequestParam String address, @RequestParam String city,
                                               @RequestParam String state, @RequestParam String zip) {
        return restaurantService.addRestaurant(id, name, hb_link, rating, hours, min_delivery, delivery_fee,
                pic_src, address, city, state, zip);
    }

    @GetMapping(path="/exists")
    public @ResponseBody boolean restaurantExists(Principal principal, @RequestParam long id) {
        return restaurantService.restaurantExists(id);
    }

    @GetMapping(path="/get")
    public @ResponseBody Restaurant getRestaurant(Principal principal, @RequestParam long id) {
        return restaurantService.getRestaurant(id);
    }

    @GetMapping(path="/getAll")
    public @ResponseBody List<Restaurant> getAllRestaurants(Principal principal) {
        return restaurantService.getAllRestaurants();
    }


}
