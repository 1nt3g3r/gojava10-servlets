package com.first.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headers = req.getHeaderNames();

        resp.setContentType("text/html; charset=UTF-8;");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        while(headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = req.getHeader(headerName);

            writer.print(headerName + ": " + headerValue);
            writer.print("<br>");
        }

        writer.flush();
    }
}
