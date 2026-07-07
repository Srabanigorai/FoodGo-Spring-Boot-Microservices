package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // Add Menu Item
    public Menu addMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    // Get All Menu Items
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    // Get Menu By Id
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    // Update Menu Item
    public Menu updateMenuItem(Long id, Menu menu) {

        Menu existing = menuRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setRestaurantId(menu.getRestaurantId());
            existing.setItemName(menu.getItemName());
            existing.setDescription(menu.getDescription());
            existing.setPrice(menu.getPrice());
            existing.setCategory(menu.getCategory());
            existing.setAvailable(menu.getAvailable());
            existing.setImageUrl(menu.getImageUrl());

            return menuRepository.save(existing);
        }

        return null;
    }

    // Delete Menu Item
    public String deleteMenuItem(Long id) {

        menuRepository.deleteById(id);

        return "Menu Item Deleted Successfully";
    }

    // Get Menu By Restaurant Id
    public List<Menu> getMenuByRestaurantId(Long restaurantId) {

        return menuRepository.findByRestaurantId(restaurantId);
    }

    // Search By Category
    public List<Menu> getMenuByCategory(String category) {

        return menuRepository.findByCategory(category);
    }

    // Get Available Items
    public List<Menu> getAvailableItems() {

        return menuRepository.findByAvailable(true);
    }

}