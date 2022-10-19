package org.epam.finalproject.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
    private String email;
    private String role = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String email, String role, HttpServletRequest request) {
        super(request);
        this.email = email;
        this.role = role;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return this.role.equals(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.email == null) {
            return realRequest.getUserPrincipal();
        }

        // Make an anonymous implementation to just return our user
        return new Principal() {
            @Override
            public String getName() {
                return email;
            }
        };
    }

    @Override
    public String toString() {
        return "UserRoleRequestWrapper{" +
                "email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", realRequest=" + realRequest +
                '}';
    }
}
