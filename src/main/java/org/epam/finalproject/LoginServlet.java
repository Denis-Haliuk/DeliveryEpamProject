package org.epam.finalproject;

import org.epam.finalproject.config.SecurityConfig;
import org.epam.finalproject.dao.UserDao;
import org.epam.finalproject.entity.User;
import org.epam.finalproject.util.AppUtils;
import org.epam.finalproject.util.LoginUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDao userDao = UserDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(SecurityConfig.getUrlPatternsForRole("customer"));
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/login.jsp").include(req, resp);
            return;
        }

        User user = userDao.getUserByCredentials(email, password);
        System.out.println(user);

        if (user == null) {
            req.getRequestDispatcher("/login.jsp").include(req, resp);
            return;
        }
        LoginUtil.loginUser(user, req, resp);
    }
}
