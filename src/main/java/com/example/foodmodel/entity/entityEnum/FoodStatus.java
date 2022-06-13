package com.example.foodmodel.entity.entityEnum;

public enum FoodStatus {
    ACTIVE(1),
    STOP(0),
    DELETE(-1),
    UNDEFINE(2);

    private int value;
    FoodStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static FoodStatus of(int value) {
        for (FoodStatus foodStatus : FoodStatus.values()) {
            if(foodStatus.getValue() == value) {
                return foodStatus;
            }
        }
        return FoodStatus.UNDEFINE;
    }
}
