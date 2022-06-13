package com.example.foodmodel.model.food;

import com.example.foodmodel.entity.Category;
import com.example.foodmodel.entity.Food;

import java.util.List;

public interface FoodModel {
    boolean save(Food food);
    boolean update(int id, Food food);
    boolean delete (int id);
    Food findById(int id);
    List<Food> findAll();
}
