package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;


 public interface ClientService {

     void createClient(ClientDTO client);

     /*List<ClientDTO> findAllClients();

     Optional<ClientDTO> getClientById(UUID id);

     void updateClientById(UUID uuid, ClientDTO client);

     void deleteClient(UUID id);*/
}

