package com.holamundo.holamundo.repository;

import com.holamundo.holamundo.models.ClientDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientRepository {
    private final List<ClientDTO> clients = new ArrayList<>();

    public ClientDTO createClient(ClientDTO client) {
        if (client.getUuid() == null){
            client.setUuid(UUID.randomUUID());
        }
        clients.add(client);
        return client;
    }

}
