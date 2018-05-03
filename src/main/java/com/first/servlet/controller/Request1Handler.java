package com.first.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Request1Handler implements RequestHandler {
    public void process(HttpServletRequest request, HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            resp.getWriter().print("One");
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
