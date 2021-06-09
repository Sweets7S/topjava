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
public class CreateMealServlet extends HttpServlet {
    private static final Logger log = getLogger(CreateMealServlet.class);
    private MealsDAO mealsDAO;

    @Override
    public void init() throws ServletException {
        mealsDAO = (MealsDAO) getServletContext().getAttribute("mealsDAO");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("create meal");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(req.getParameter("id") == "") {
            mealsDAO.createMeal(req.getParameter("date"), req.getParameter("description"), req.getParameter("calories"));
        } else {
            mealsDAO.updateMeal(req.getParameter("date"),req.getParameter("description"),req.getParameter("calories"), req.getParameter("id"));
        }
        resp.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("do get in create");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(req.getParameter("id") != null) {
            req.setAttribute("meal", mealsDAO.getMealForId(Integer.parseInt(req.getParameter("id"))));
        }
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }
}