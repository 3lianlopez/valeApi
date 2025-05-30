package com.holamundo.holamundo.models;

import java.util.UUID;


public class ClientDTO {

    private UUID uuid;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private String direccion;

    // Constructores
    public ClientDTO(UUID uuid, String nombres, String apellidos, String tipoDocumento, String documento, String direccion) {
        this.uuid = uuid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.direccion = direccion;
    }

    // Getters and Setters
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
