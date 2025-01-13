package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Client;
import br.edu.ufrn.repository.ClientDao;

public class ClientService {
    
    private ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public Client getClientById(Long id) {
        return clientDao.findById(id);
    }
   
    public List<Client> getClients() {
        return clientDao.findAll();
    }

    public boolean save(Client client) {
        return clientDao.save(client);
    }

    public boolean update(Client client, String[] params) {
        return clientDao.update(client, params);
    }

    public boolean delete(Long id) {
        return clientDao.delete(id);
    }
}
