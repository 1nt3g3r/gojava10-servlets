package com.first.servlet.controller.account;

import com.first.servlet.controller.Controller;
import com.first.servlet.domain.BankAccount;
import com.first.servlet.domain.Client;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

public class AccountAbstractController extends Controller {
    protected CrudRepository<BankAccount, Long> accounts() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getInstance().getService(CrudRepositoryService.class);
        CrudRepository<BankAccount, Long> accountRepository = crudRepositoryService.getRepository(BankAccount.class);
        return accountRepository;
    }

    protected BankAccount getAccountById(long id) {
        return accounts().getById(id);
    }

    protected void updateClient(BankAccount account) {
        accounts().update(account);
    }

    protected CrudRepository<Client, Long> clients() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getInstance().getService(CrudRepositoryService.class);
        CrudRepository<Client, Long> clientRepository = crudRepositoryService.getRepository(Client.class);
        return clientRepository;
    }

    protected Client getClientById(long id) {
        return clients().getById(id);
    }

    protected void updateClient(Client client) {
        clients().update(client);
    }
}
