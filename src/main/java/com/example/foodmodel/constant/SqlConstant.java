package com.example.foodmodel.constant;

public class SqlConstant {
    public static final String FOOD_INSERT = "INSERT INTO foods ( categoryId, name, description, thumbnail, price, status, saleAt," +
            "createdAt, updatedAt, createdBy, updatedBy ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? );";
    public static final String FOOD_UPDATE = "UPDATE foods SET categoryId = ?, name = ?, description = ?, thumbnail = ?, price = ?, status = ?,  " +
            "createdAt = ?, updatedAt = ?,  createdBy = ?, updatedBy = ?, saleAt = ?  WHERE id = ?;";
    public static final String FOOD_DELETE = "DELETE FROM foods WHERE id = ?;";
    public static final String FOOD_FIND_BY_ID = "SELECT * FROM foods WHERE id = ? AND status = ?;";
    public static final String FOOD_FIND_BY_ALL = "SELECT * FROM foods WHERE status = ?;";

    public static final String CATEGORY_INSERT = "INSERT INTO categories (name, createdAt, updatedAt,createdBy, updatedBy) values (?,?,?,?,?)";
    public static final String CATEGORY_UPDATE = "UPDATE categories SET name = ?, udpatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String CATEGORY_DELETE = "DELETE FROM categories WHERE id = ?;";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM categories WHERE id = ?";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM categories ";

}

