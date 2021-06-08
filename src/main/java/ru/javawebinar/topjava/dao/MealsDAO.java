package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealsDAO {
    public static final int CALORIES_PER_DAY = 2500;

    List<Meal> getMeals();

    void deleteMeal(int id);

    Meal getMealForId(int id);
}
