package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

// Sweets
public class DeleteMealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealsDAO mealsDAO;

    @Override
    public void init() throws ServletException {
        mealsDAO = (MealsDAO) getServletContext().getAttribute("mealsDAO");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("delete meal");
        System.out.println(req.getParameter("id"));
        mealsDAO.deleteMeal(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("meals");
    }
}
