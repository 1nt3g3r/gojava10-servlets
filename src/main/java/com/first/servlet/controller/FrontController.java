package com.first.servlet.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/*")
public class FrontController extends HttpServlet {
    private Map<String, RequestHandler> handlers;

    @Override
    public void init(ServletConfig config) throws ServletException {
        handlers = new HashMap<String, RequestHandler>();
        handlers.put("/1", new Request1Handler());
        handlers.put("/2", new Request2Handler());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        handlers.get(url).process(req, resp);
    }
}
