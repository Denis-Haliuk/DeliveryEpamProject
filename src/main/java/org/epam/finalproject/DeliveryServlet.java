package org.epam.finalproject;

import org.epam.finalproject.dao.DeliveryDao;
import org.epam.finalproject.entity.Delivery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {

    DeliveryDao deliveryDao = DeliveryDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create_delivery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Delivery delivery = new Delivery();
        delivery.setUserId(Integer.parseInt(req.getParameter("user_id")));
        delivery.setTypeId(Integer.parseInt(req.getParameter("type_id")));
        delivery.setDirectionId(Integer.parseInt(req.getParameter("direction_id")));
        delivery.setWeight(Integer.parseInt(req.getParameter("weight")));

        delivery.setFullName(req.getParameter("full_name"));
        delivery.setSenderPhone(Integer.parseInt(req.getParameter("sender_phone")));

        delivery.setReceiverName(req.getParameter("receiver_name"));
        delivery.setReceiverPhone(Integer.parseInt(req.getParameter("receiver_phone")));
        delivery.setReceiverAddress(req.getParameter("receiver_address"));

        delivery.setDate(new Date(new java.util.Date().getTime()));

        System.out.println(delivery);
        deliveryDao.createDelivery(delivery);

        resp.sendRedirect(req.getContextPath() + "/userPage");
    }
}
