package com.example.foodmodel.controller.food;

import com.example.foodmodel.entity.Category;
import com.example.foodmodel.entity.Food;
import com.example.foodmodel.entity.entityEnum.FoodStatus;
import com.example.foodmodel.model.category.MySqlCategoryModel;
import com.example.foodmodel.model.food.MySqlFoodModel;
import com.example.foodmodel.util.FormatterHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class CreateFoodServlet extends HttpServlet {
    private MySqlFoodModel foodModel;
    private MySqlCategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories =  categoryModel.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/admin/views/food/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String thumbnail = req.getParameter("thumbnail");
        FoodStatus status = FoodStatus.of(Integer.parseInt(req.getParameter("status")));
        LocalDateTime saleAt = FormatterHelper.convertStringToLocalDateTime(req.getParameter("saleAt") + " 00:00", "yyyy-MM-dd HH:mm");
        Food food = new Food( name,categoryId , description,  thumbnail,price,  status, saleAt);
        if(food.isValid()) {
            foodModel.save(food);
            resp.sendRedirect("/admin/foods/list");
        }else {
            List<Category> categories =  categoryModel.findAll();
            req.setAttribute("categories", categories);
            req.setAttribute("errors", food.getErrors());
            req.setAttribute("food", food); // set lai product de luu ga tri
            req.getRequestDispatcher("/admin/views/food/create.jsp").forward(req,resp);
        }
    }
}
