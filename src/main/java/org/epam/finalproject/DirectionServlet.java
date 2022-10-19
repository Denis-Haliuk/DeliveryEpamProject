package org.epam.finalproject;

import org.epam.finalproject.dao.DirectionDao;
import org.epam.finalproject.entity.Direction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/directions")
public class DirectionServlet extends HttpServlet {

    DirectionDao directionDao = DirectionDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sort = req.getParameter("sort");
        List<Direction> directionList = directionDao.findAllDirections(sort);

        req.setAttribute("directionList", directionList);
        req.getRequestDispatcher("/directions.jsp").forward(req, resp);
    }
}
