package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int userId) {
        return repository.save(meal, userId);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Meal get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public List<MealTo> getAll(int userId, String min, String max, String dateBefore, String dateAfter){
        LocalTime minTime = DateTimeUtil.parseOrDefaultTimeMin(min);
        LocalTime maxTime = DateTimeUtil.parseOrDefaultTimeMax(max);
        LocalDate before = DateTimeUtil.parseOrDefaultDateMin(dateBefore);
        LocalDate after = DateTimeUtil.parseOrDefaultDateMax(dateAfter);
        return MealsUtil.getFilteredTos(repository.getAll(userId, before, after), MealsUtil.DEFAULT_CALORIES_PER_DAY, minTime, maxTime);
    }

    public List<MealTo> getAll(int userId){
        return MealsUtil.getFilteredTos(repository.getAll(userId, LocalDate.MIN, LocalDate.MAX), MealsUtil.DEFAULT_CALORIES_PER_DAY, LocalTime.MIN, LocalTime.MAX);
    }

    public void update(Meal meal, int userId) { ;
        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }

}