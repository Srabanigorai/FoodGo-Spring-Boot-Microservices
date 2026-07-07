package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Add Restaurant
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Get All Restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Get Restaurant By Id
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    // Update Restaurant
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {

        Restaurant existing = restaurantRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setRestaurantName(restaurant.getRestaurantName());
            existing.setOwnerName(restaurant.getOwnerName());
            existing.setEmail(restaurant.getEmail());
            existing.setPhone(restaurant.getPhone());
            existing.setAddress(restaurant.getAddress());
            existing.setCity(restaurant.getCity());
            existing.setState(restaurant.getState());
            existing.setPincode(restaurant.getPincode());
            existing.setCuisine(restaurant.getCuisine());
            existing.setOpeningTime(restaurant.getOpeningTime());
            existing.setClosingTime(restaurant.getClosingTime());
            existing.setImageUrl(restaurant.getImageUrl());
            existing.setRating(restaurant.getRating());
            existing.setDeliveryTime(restaurant.getDeliveryTime());
            existing.setIsOpen(restaurant.getIsOpen());

            return restaurantRepository.save(existing);
        }

        return null;
    }

    // Delete Restaurant
    public String deleteRestaurant(Long id) {

        restaurantRepository.deleteById(id);

        return "Restaurant Deleted Successfully";
    }

    // Search By City
    public List<Restaurant> searchByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    // Search By Cuisine
    public List<Restaurant> searchByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    // Get Open Restaurants
    public List<Restaurant> getOpenRestaurants() {
        return restaurantRepository.findByIsOpen(true);
    }

}