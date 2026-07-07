package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Add Menu Item
    @PostMapping
    public Menu addMenuItem(@RequestBody Menu menu) {
        return menuService.addMenuItem(menu);
    }

    // Get All Menu Items
    @GetMapping
    public List<Menu> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    // Get Menu Item By Id
    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // Update Menu Item
    @PutMapping("/{id}")
    public Menu updateMenuItem(@PathVariable Long id,
                               @RequestBody Menu menu) {
        return menuService.updateMenuItem(id, menu);
    }

    // Delete Menu Item
    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        return menuService.deleteMenuItem(id);
    }

    // Get Menu By Restaurant Id
    @GetMapping("/restaurant/{restaurantId}")
    public List<Menu> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        return menuService.getMenuByRestaurantId(restaurantId);
    }

    // Search By Category
    @GetMapping("/category/{category}")
    public List<Menu> getMenuByCategory(@PathVariable String category) {
        return menuService.getMenuByCategory(category);
    }

    // Get Available Items
    @GetMapping("/available")
    public List<Menu> getAvailableItems() {
        return menuService.getAvailableItems();
    }

}