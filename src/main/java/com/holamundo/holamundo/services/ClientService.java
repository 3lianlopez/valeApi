package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(ClientDTO client){
        clientRepository.createClient(client);
    }

    public List<ClientDTO> getClient(){
        return clientRepository.findAll();
    }

    public Optional<ClientDTO> getClientById(UUID id){
        return clientRepository.findById(id);
    }

    public void updateClientById(UUID uuid, ClientDTO client){
        clientRepository.updateClient(uuid, client);
    }

    public void deleteClient(UUID id){
        clientRepository.deleteById(id);
    }
}
