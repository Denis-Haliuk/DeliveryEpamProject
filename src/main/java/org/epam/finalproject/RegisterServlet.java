package org.epam.finalproject;

import org.epam.finalproject.dao.UserDao;
import org.epam.finalproject.entity.User;
import org.epam.finalproject.util.AppUtils;
import org.epam.finalproject.util.LoginUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    UserDao userDao = UserDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/register.jsp").include(req, resp);
        } else {
            User user = new User();
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            userDao.insertUser(user);

            user = userDao.getUserByCredentials(email, password);

            if (user == null) {
                req.getRequestDispatcher("/register.jsp").include(req, resp);
                return;
            }
            LoginUtil.loginUser(user, req, resp);
        }

    }
}
