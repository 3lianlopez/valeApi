package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientServicesImp {

    public void createClient(ClientDTO client);

    public List<ClientDTO> getClient();

    public Optional<ClientDTO> getClientById(UUID id);

    public void updateClientById(UUID uuid, ClientDTO client);

    public void deleteClient(UUID id);
}
