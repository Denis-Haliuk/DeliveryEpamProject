package org.epam.finalproject;

import org.epam.finalproject.dao.UserDao;
import org.epam.finalproject.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    UserDao userDao = UserDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.findAllUsers();
        System.out.println(users);
        req.setAttribute("userList", users);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

}
