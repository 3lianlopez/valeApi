package com.holamundo.holamundo.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
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
