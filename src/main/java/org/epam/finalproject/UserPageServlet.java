package org.epam.finalproject;

import org.epam.finalproject.dao.DeliveryDao;
import org.epam.finalproject.entity.Delivery;
import org.epam.finalproject.entity.User;
import org.epam.finalproject.util.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {

    DeliveryDao deliveryDao = DeliveryDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = AppUtils.getLoginedUser(request.getSession()).getId();

        List<Delivery> deliveryList = deliveryDao.findAllByUserId(id);

        request.setAttribute("deliveryList", deliveryList);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/user_page.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stateId = Integer.parseInt(request.getParameter("stateId"));
        int idDelivery = Integer.parseInt(request.getParameter("idDelivery"));

        deliveryDao.update(stateId, idDelivery);
        response.sendRedirect(request.getContextPath() + "/userPage");



    }
}
