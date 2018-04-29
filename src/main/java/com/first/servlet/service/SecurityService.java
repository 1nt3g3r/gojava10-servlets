package com.first.servlet.service;

import javax.servlet.http.HttpSession;

public class SecurityService {
    public static final String LOGGED_IN_NAME = "loggedIn";

    public boolean userExists(String login, String password) {
        return login.equals("admin") && password.equals("admin");
    }

    public boolean isLoggedIn(HttpSession session) {
        if (session.getAttribute(LOGGED_IN_NAME) == null) {
            return false;
        }

        return Boolean.parseBoolean(session.getAttribute(LOGGED_IN_NAME).toString());
    }

    public void setLoggedIn(HttpSession session, boolean loggedIn) {
        session.setAttribute(LOGGED_IN_NAME, loggedIn);
    }
}
