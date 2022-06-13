package com.example.foodmodel.controller.food;

import com.example.foodmodel.entity.Food;
import com.example.foodmodel.model.food.FoodModel;
import com.example.foodmodel.model.food.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FoodListServlet extends HttpServlet {
    private FoodModel foodModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foodList = foodModel.findAll();
        req.setAttribute("foodList", foodList);
        req.getRequestDispatcher("/admin/views/food/list.jsp").forward(req, resp);
    }
}
