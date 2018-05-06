package com.first.servlet.controller.client;

import com.first.servlet.controller.Controller;
import com.first.servlet.domain.Client;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientDeleteController extends ClientAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long clientId = Long.parseLong(request.getParameter("id"));
        clients().deleteById(clientId);

        response.sendRedirect("/");
    }
}
