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

    //este metodo deberia detornar un objetode respuesta.
    public void createClient(ClientDTO client){
        clientRepository.createClient(client);
    }

    public List<ClientDTO> getClient(){
        return clientRepository.findAll();
    }

    //este metodo deberia retornar un objeto de respuesta.
    public Optional<ClientDTO> getClientById(UUID id){
        return clientRepository.findById(id);
    }

    //este metodo deberia retornar un objeto de respuesta.
    public void updateClientById(UUID uuid, ClientDTO client){
        clientRepository.updateClient(uuid, client);
    }

    //este metodo deberia retornar un objeto de respuesta.
    public void deleteClient(UUID id){
        clientRepository.deleteById(id);
    }
}
