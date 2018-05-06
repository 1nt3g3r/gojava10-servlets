package com.first.servlet.controller.client;

import com.first.servlet.domain.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientAddController extends ClientAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/jsp/client-add.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String clientFirstName = request.getParameter("clientFirstName");
        String clientLastName = request.getParameter("clientLastName");

        Client client = new Client();
        client.setFirstName(clientFirstName);
        client.setLastName(clientLastName);

        clients().create(client);

        response.sendRedirect("/");
    }
}
