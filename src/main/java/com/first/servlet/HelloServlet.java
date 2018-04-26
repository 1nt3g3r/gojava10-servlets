package com.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html;
        String paramValue = req.getParameter("text");

        if (paramValue == null) {
            html = "<h1>No parameter :( </h1>";
        } else {
            html = "<h1>" + paramValue + "</h1>";
        }

        resp.setContentType("text/html; charset=UTF-8;");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write(html);
        writer.flush();
    }
}