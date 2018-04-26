package com.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("testCookie", "testValue");
        resp.addCookie(cookie);

        resp.setContentType("text/html; charset=UTF-8;");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().print("Cookie added!");
    }
}
