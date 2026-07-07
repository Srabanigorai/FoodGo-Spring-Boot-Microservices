package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Add Restaurant
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {

        System.out.println("Restaurant Name : " + restaurant.getRestaurantName());
        System.out.println("Owner Name      : " + restaurant.getOwnerName());
        System.out.println("Phone           : " + restaurant.getPhone());
        System.out.println("Address         : " + restaurant.getAddress());
        System.out.println("City            : " + restaurant.getCity());
        System.out.println("Cuisine         : " + restaurant.getCuisine());

        return restaurantService.addRestaurant(restaurant);
    }

    // Get All Restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get Restaurant By Id
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    // Update Restaurant
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,
                                       @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    // Delete Restaurant
    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        return restaurantService.deleteRestaurant(id);
    }

    // Search By City
    @GetMapping("/city/{city}")
    public List<Restaurant> searchByCity(@PathVariable String city) {
        return restaurantService.searchByCity(city);
    }

    // Search By Cuisine
    @GetMapping("/cuisine/{cuisine}")
    public List<Restaurant> searchByCuisine(@PathVariable String cuisine) {
        return restaurantService.searchByCuisine(cuisine);
    }

    // Get Open Restaurants
    @GetMapping("/open")
    public List<Restaurant> getOpenRestaurants() {
        return restaurantService.getOpenRestaurants();
    }

}