package org.epam.finalproject.util;

import org.epam.finalproject.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUtil {
    public static void loginUser(User user, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AppUtils.storeLoginedUser(req.getSession(), user);
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);

        if (requestUri != null) {
            resp.sendRedirect(requestUri);
        } else {
            resp.sendRedirect(req.getContextPath() + "/userPage");
        }
    }
}

