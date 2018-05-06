package com.first.servlet.controller.account;

import com.first.servlet.domain.BankAccount;
import com.first.servlet.domain.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class AccountListController extends AccountAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long clientId = Long.parseLong(request.getParameter("clientId"));
        Client client = clients().getById(clientId);

        Set<BankAccount> accounts = client.getAccounts();

        request.setAttribute("client", client);
        request.setAttribute("accounts", accounts);

        System.out.println("In controller");

        request.getRequestDispatcher("/jsp/account-list.jsp").forward(request, response);
    }
}
