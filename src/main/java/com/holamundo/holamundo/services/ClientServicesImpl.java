package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ClientServicesImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServicesImpl.class);
    private final ClientRepository clientRepository;


    public ClientServicesImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(ClientDTO client){
        log.info("Creando nuevo cliente: {}", client.getDoc());
        clientRepository.createClient(client);

    }

    /*public List<ClientDTO> findAllClients(){
        return clientRepository.findAllClients();
    }

    @Override
    public Optional<ClientDTO> getClientById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateClientById(UUID uuid, ClientDTO client) {

    }

    @Override
    public void deleteClient(UUID id) {

    }*/
}
