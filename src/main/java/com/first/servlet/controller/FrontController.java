package com.first.servlet.controller;

import com.first.servlet.controller.account.AccountAddController;
import com.first.servlet.controller.account.AccountListController;
import com.first.servlet.controller.client.ClientAddController;
import com.first.servlet.controller.client.ClientDeleteController;
import com.first.servlet.controller.client.ClientEditController;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter({"/*", "/**"})
public class FrontController implements Filter {
    private Map<String, Controller> handlers;

    public void init(FilterConfig filterConfig) throws ServletException {
        ServiceRepository.getInstance();

        handlers = new HashMap<String, Controller>();
        handlers.put("/", new IndexController());

        handlers.put("/client_edit", new ClientEditController());
        handlers.put("/client_delete", new ClientDeleteController());
        handlers.put("/client_add", new ClientAddController());

        handlers.put("/client/accounts", new AccountListController());
        handlers.put("/client/account_add", new AccountAddController());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletRequest.setCharacterEncoding("UTF-8");

        String uri = httpServletRequest.getRequestURI();

        if (uri.endsWith(".jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            try {
                handlers.get(uri).process(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {}
}
