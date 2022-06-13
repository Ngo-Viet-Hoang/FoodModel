package com.example.foodmodel.model.food;

import com.example.foodmodel.entity.Category;
import com.example.foodmodel.entity.Food;
import com.example.foodmodel.entity.entityEnum.FoodStatus;
import com.example.foodmodel.model.category.MySqlCategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlFoodModelTest {
    private FoodModel foodModel;

    @BeforeEach
    void setUp() {
        foodModel = new MySqlFoodModel();
    }

    @Test
    void save() {
        Food product = new Food("pen111", 9, "detail", "image.jsp",1, FoodStatus.ACTIVE,LocalDateTime.now());
        assertEquals(true, foodModel.save(product));
    }

    @Test
    void findAll() {
        MySqlFoodModel mySqlFoodModel = new MySqlFoodModel();
        List<Food> list = mySqlFoodModel.findAll() ;
        assertNotEquals(0, list.size());
    }
}