package com.example.foodmodel.entity;

import com.example.foodmodel.entity.base.BaseEntity;
import com.example.foodmodel.entity.entityEnum.FoodStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Food extends BaseEntity {
    public int id;
    public String name;
    public int categoryId;
    public String description;
    public String thumbnail;
    public double price;
    public FoodStatus status;
    private LocalDateTime saleAt;
    private HashMap<String, String> errors;

    public Food() {
        errors = new HashMap<>();
        this.name = "";
        this.description = "";
        this.price = 0.0;
        this.thumbnail = "";
    }

    public Food(String name, int categoryId, String description, String thumbnail, double price, FoodStatus status, LocalDateTime saleAt) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.saleAt = saleAt;
    }

    public Food(int id, String name, int categoryId, String description, String thumbnail, double price, FoodStatus status, LocalDateTime saleAt) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.saleAt = saleAt;
    }

    public Food(int id, String name, int categoryId, String description, String thumbnail, double price, FoodStatus status, LocalDateTime saleAt, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.saleAt = saleAt;
        errors = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodStatus getStatus() {
        return status;
    }

    public void setStatus(FoodStatus status) {
        this.status = status;
    }

    public LocalDateTime getSaleAt() {
        return saleAt;
    }

    public void setSaleAt(LocalDateTime saleAt) {
        this.saleAt = saleAt;
    }

    public HashMap<String, String> getErrors(){
        return errors;
    }
    public boolean isValid() {
        return this.checkValid();
    }
    public boolean checkValid() {
        if(name == "" || name == null) {
            errors.put("name", "Please enter name");
        }
        if(price == 0) {
            errors.put("price", "Please enter price");
        }
        if(thumbnail == "" || thumbnail == null) {
            errors.put("thumbnail", "Please enter thumbnail");
        }
        return errors.size() == 0;

    }
}
