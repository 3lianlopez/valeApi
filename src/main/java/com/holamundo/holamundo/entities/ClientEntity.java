package com.holamundo.holamundo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClientEntity {

    @Id
    private UUID uuid;

    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private String direccion;

    public ClientEntity(){}
}
