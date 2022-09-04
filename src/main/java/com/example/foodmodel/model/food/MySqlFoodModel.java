package com.example.foodmodel.model.food;

import com.example.foodmodel.constant.SqlConstant;
import com.example.foodmodel.entity.Food;
import com.example.foodmodel.entity.entityEnum.FoodStatus;
import com.example.foodmodel.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlFoodModel implements FoodModel {
    @Override
    public boolean save(Food food) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_INSERT);
            preparedStatement.setInt(1,food.getCategoryId());
            preparedStatement.setString(2, food.getName());
            preparedStatement.setString(3, food.getDescription());
            preparedStatement.setString(4, food.getThumbnail());
            preparedStatement.setDouble(5, food.getPrice());
            preparedStatement.setInt(6, food.getStatus().getValue());
            preparedStatement.setString(7, food.getSaleAt() != null ? food.getSaleAt().toString() : null);
            preparedStatement.setString(8, food.getCreatedAt().toString());
            preparedStatement.setString(9, food.getUpdatedAt().toString());
            preparedStatement.setInt(10, food.getCreatedBy());
            preparedStatement.setInt(11, food.getUpdatedBy());

            return preparedStatement.executeUpdate() >0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Food food) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_UPDATE);
            preparedStatement.setInt(1,food.getCategoryId());
            preparedStatement.setString(2, food.getName());
            preparedStatement.setString(3, food.getDescription());
            preparedStatement.setString(4, food.getThumbnail());
            preparedStatement.setDouble(5, food.getPrice());
            preparedStatement.setInt(6, food.getStatus().getValue());
            preparedStatement.setString(7, food.getSaleAt() != null ? food.getSaleAt().toString() : null);  
            preparedStatement.setString(8, food.getCreatedAt().toString());
            preparedStatement.setString(9, food.getUpdatedAt().toString());
            preparedStatement.setInt(10, food.getCreatedBy());
            preparedStatement.setInt(11, food.getUpdatedBy());

            return preparedStatement.executeUpdate() >0;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Food findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, FoodStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                FoodStatus status = FoodStatus.values()[rs.getInt("status")];
                LocalDateTime saleAt = rs.getTimestamp("saleAt").toLocalDateTime();
                Food food = new Food(id,name, categoryId,  description, thumbnail, price,status,saleAt,createdAt, updatedAt, deletedAt, createdBy, updatedBy,deletedBy);
                return food;
            }
        }catch (SQLException e) {
          e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Food> findAll() {
        List<Food> foods =new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_FIND_BY_ALL);
            preparedStatement.setInt(1, FoodStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                int categoryId = rs.getInt("categoryId");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                FoodStatus status = FoodStatus.values()[rs.getInt("status")];
                LocalDateTime saleAt = rs.getTimestamp("saleAt").toLocalDateTime();
                Food food = new Food(id,name, categoryId,   description, thumbnail, price,status,saleAt, createdAt, updatedAt, deletedAt, createdBy, updatedBy,deletedBy );
                foods.add(food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return foods;
    }


}
