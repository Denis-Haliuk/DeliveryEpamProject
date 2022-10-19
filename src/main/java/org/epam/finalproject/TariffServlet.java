package org.epam.finalproject;

import org.epam.finalproject.dao.TariffDao;
import org.epam.finalproject.entity.Direction;
import org.epam.finalproject.entity.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tariffs")
public class TariffServlet extends HttpServlet {

    TariffDao tariffDao = TariffDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sort = req.getParameter("sort");
        List<Tariff> tariffList = tariffDao.findAllTariffs(sort);

        req.setAttribute("tariffList", tariffList);
        req.getRequestDispatcher("/tariffs.jsp").forward(req, resp);
    }
}
