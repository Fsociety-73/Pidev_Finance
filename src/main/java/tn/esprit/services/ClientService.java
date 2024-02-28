package tn.esprit.services;

import tn.esprit.interfaces.IClientService;
import tn.esprit.models.Client;

import java.sql.Connection;

public class ClientService extends ServiceUser<Client> implements IClientService {
    public ClientService(Connection cnx) {
        super("client");
    }
}
