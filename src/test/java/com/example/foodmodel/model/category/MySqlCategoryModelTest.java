package com.example.foodmodel.model.category;

import com.example.foodmodel.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {

    private CategoryModel categoryModel;

    @BeforeEach
    void setUp() {
        categoryModel = new MySqlCategoryModel();
    }

    @Test
    void save() {
        Category category = new Category("pen2" );
        assertEquals(true, categoryModel.save(category));
    }

    @Test
    void findAll() {
        MySqlCategoryModel mySqlCategoryModel = new MySqlCategoryModel();
        List<Category> list = mySqlCategoryModel.findAll() ;
        assertNotEquals(0, list.size());
    }
}