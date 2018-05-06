package com.first.servlet.controller.client;

import com.first.servlet.domain.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientEditController extends ClientAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long clientId = Long.parseLong(request.getParameter("id"));
        Client client = getClientById(clientId);

        request.setAttribute("client", client);

        request.getRequestDispatcher("/jsp/client-edit.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long clientId = Long.parseLong(request.getParameter("id"));
        Client client = getClientById(clientId);

        String firstName = request.getParameter("clientFirstName");
        String lastName = request.getParameter("clientLastName");

        client.setFirstName(firstName);
        client.setLastName(lastName);

        updateClient(client);

        response.sendRedirect("/");
    }
}
