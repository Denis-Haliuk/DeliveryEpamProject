package org.epam.finalproject;

import org.epam.finalproject.dao.DeliveryDao;
import org.epam.finalproject.entity.Delivery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userDeliveries")
public class UserDeliveriesServlet extends HttpServlet {

    DeliveryDao deliveryDao = DeliveryDao.getInstance();
    int userId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userId = Integer.parseInt(req.getParameter("userId"));
        List<Delivery> deliveries = deliveryDao.findAllByUserId(userId);
        req.setAttribute("deliveries", deliveries);
        req.getRequestDispatcher("userDeliveries.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stateId = Integer.parseInt(req.getParameter("stateId"));
        int idDelivery = Integer.parseInt(req.getParameter("idDelivery"));

        deliveryDao.update(stateId, idDelivery);
        resp.sendRedirect(req.getContextPath() + "/userDeliveries?userId="+userId);
    }
}
