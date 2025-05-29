package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;


 public interface ClientService {

     void createClient(ClientDTO client);

    
    //este metodo deberia detornar un objetode respuesta.
    void createClient(ClientDTO client){
        clientRepository.createClient(client);
    }
      
    /*List<ClientDTO> findAllClients();
    
     Optional<ClientDTO> getClientById(UUID id);

     void updateClientById(UUID uuid, ClientDTO client);

     void deleteClient(UUID id);
   
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
    }*/
}

