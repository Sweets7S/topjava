package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.dao.MealsDAO;
import ru.javawebinar.topjava.dao.MealsDAOimpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// Sweets
@WebListener
public class ContextListener implements ServletContextListener {
    private final MealsDAO mealsDAO;

    public ContextListener() {
        this.mealsDAO = new MealsDAOimpl();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("mealsDAO", mealsDAO);
    }
}
