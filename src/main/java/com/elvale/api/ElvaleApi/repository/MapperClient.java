package com.elvale.api.ElvaleApi.repository;


import com.elvale.api.ElvaleApi.entities.ClientEntity;
import com.elvale.api.ElvaleApi.models.ClientDTO;

public class MapperClient {

    public ClientEntity dtoToEntity(ClientDTO clientDTO){
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setUuid(clientDTO.getUuid());
        clientEntity.setNombres(clientDTO.getNombres());
        clientEntity.setApellidos(clientDTO.getApellidos());
        clientEntity.setTipoDocumento(clientDTO.getTipoDocumento());
        clientEntity.setDocumento(clientDTO.getDocumento());
        clientEntity.setDireccion(clientDTO.getDireccion());

        return clientEntity;
    }

    public ClientDTO entityToDto(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setUuid(clientEntity.getUuid());
        clientDTO.setNombres(clientEntity.getNombres());
        clientDTO.setApellidos(clientEntity.getApellidos());
        clientDTO.setTipoDocumento(clientEntity.getTipoDocumento());
        clientDTO.setDocumento(clientEntity.getDocumento());
        clientDTO.setDireccion(clientEntity.getDireccion());

        return clientDTO;
    }
}
