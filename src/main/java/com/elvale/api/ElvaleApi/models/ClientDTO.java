package com.elvale.api.ElvaleApi.models;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
public class ClientDTO {

    // Getters and Setters
    private UUID uuid;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private String direccion;

    public ClientDTO(){}
    // Constructores
    public ClientDTO(UUID uuid, String nombres, String apellidos, String tipoDocumento, String documento, String direccion) {
        this.uuid = uuid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.direccion = direccion;
    }

}
