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

    /*public List<ClientDTO> findAllClients(){
        return clients;
    }

    public Optional<ClientDTO> findById(UUID id){
        return clients.stream().filter(client -> client.getUuid().equals(id)).findFirst();
    }

    public ClientDTO updateClient(UUID uuid, ClientDTO client){
        Optional<ClientDTO> clientExist = findById(uuid);

        if (clientExist.isPresent()){
            deleteById(uuid);
            client.setUuid(uuid);
            clients.add(client);
            return client;
        }

        return null;
    }

    public void deleteById(UUID id){
        clients.removeIf(ClientDTO -> ClientDTO.getUuid().equals(id));
    }*/
}
