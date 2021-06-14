package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(meal -> save(meal, SecurityUtil.authUserId()));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setUserId(userId);
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        // handle case: update, but not present in storage
        if (get(meal.getId(), userId) != null) {
            return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
        } else return null;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Meal get(int id, int userId) {
        if(0 >= id || repository.get(id) == null || repository.get(id).getUserId() != userId){
            return null;
        }
        return repository.get(id);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        return repository.values().stream().filter(meal -> meal.getUserId() == userId).sorted(Comparator.comparing(Meal::getDate).reversed()).collect(Collectors.toList());
    }


}

