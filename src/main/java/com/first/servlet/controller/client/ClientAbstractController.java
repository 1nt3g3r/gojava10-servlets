package com.first.servlet.controller.client;

import com.first.servlet.controller.Controller;
import com.first.servlet.domain.Client;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

public class ClientAbstractController extends Controller {
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
