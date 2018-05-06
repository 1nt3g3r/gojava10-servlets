package com.first.servlet.controller.account;

import com.first.servlet.domain.BankAccount;
import com.first.servlet.domain.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountAddController extends AccountAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("clientId", request.getParameter("clientId"));
        request.getRequestDispatcher("/jsp/account-add.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        int accountMoney = Integer.parseInt(request.getParameter("accountMoney"));
        long clientId = Long.parseLong(request.getParameter("clientId"));

        Client client = clients().getById(clientId);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setClient(client);
        bankAccount.setMoney(accountMoney);
        bankAccount.setNumber(accountNumber);
        client.getAccounts().add(bankAccount);

        clients().update(client);

        response.sendRedirect("/client/accounts?clientId=" + clientId);
    }
}
