package com.example.foodmodel.controller.category;

import com.example.foodmodel.entity.Category;
import com.example.foodmodel.model.category.CategoryModel;
import com.example.foodmodel.model.category.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;
    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));
        if(categoryModel.delete(categoryId)) {
            resp.sendRedirect("/admin/categories/list");
        }
    }
}
