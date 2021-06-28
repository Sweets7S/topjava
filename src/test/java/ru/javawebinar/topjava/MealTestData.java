package ru.javawebinar.topjava;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;
// Sweets
public class MealTestData {
    public static final int NOT_FOUND = 20;
    public static AtomicInteger mealId = new AtomicInteger(START_SEQ + 2);
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static final Meal ONE_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-30 10:00", formatter), "Завтрак", 500);
    public static final Meal TWO_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-30 13:00", formatter), "Обед", 1000);
    public static final Meal THREE_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-30 20:00", formatter), "Ужин", 500);
    public static final Meal FOUR_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 00:00", formatter), "Еда на граничное значение", 100);
    public static final Meal FIVE_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 10:00", formatter), "Завтрак", 500);
    public static final Meal SIX_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 13:00", formatter), "Обед", 1000);
    public static final Meal SEVEN_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 20:00", formatter), "Ужин", 510);
    public static final Meal EIGHT_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 14:00", formatter), "Админ ланч", 510);
    public static final Meal NINE_MEAL = new Meal(mealId.getAndIncrement(), LocalDateTime.parse("2020-01-31 21:00", formatter), "Админ ужин", 1500);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.parse("2020-02-01 10:00", formatter), "NewDescription", 500);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(ONE_MEAL);
        updated.setDescription("UpdateDescription");
        updated.setCalories(1000);
        updated.setDateTime(LocalDateTime.parse("2020-03-01 10:00", formatter));
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("id").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("id").isEqualTo(expected);
    }
}
