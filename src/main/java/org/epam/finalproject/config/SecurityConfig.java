package org.epam.finalproject.config;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_CUSTOMER = "customer";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_MANAGER = "manager";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "EMPLOYEE".
        List<String> adminAccess = new ArrayList<String>();

        adminAccess.add("/users");
        adminAccess.add("/userPage");
        adminAccess.add("/delivery");
        adminAccess.add("/userDeliveries");
        mapConfig.put(ROLE_ADMIN, adminAccess);

        // Конфигурация для роли "MANAGER".
        List<String> managerAccess = new ArrayList<String>();

        managerAccess.add("/users");
        managerAccess.add("/userPage");
        managerAccess.add("/delivery");
        managerAccess.add("/userDeliveries");
        mapConfig.put(ROLE_MANAGER, managerAccess);

        List<String> customerAccess = new ArrayList<String>();

        customerAccess.add("/userPage");
        customerAccess.add("/delivery");
        mapConfig.put(ROLE_CUSTOMER, customerAccess);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
