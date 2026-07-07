package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantId(Long restaurantId);

    List<Menu> findByCategory(String category);

    List<Menu> findByAvailable(Boolean available);

}