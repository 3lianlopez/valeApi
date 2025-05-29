package com.holamundo.holamundo.models;

import java.util.UUID;

//implementar Lombok
//@Data
//@AllArgsConstructor
public class ClientDTO {

    private UUID uuid;
    private String nombres; 
    private String apellidos; 
    private String tDoc; //este atributo debe ser tipoDocumento
    private String doc; // este atributo debe ser documento
    private String direccion;

    public ClientDTO(UUID uuid, String nombres, String apellidos, String tDoc, String doc, String direccion) {
        this.uuid = uuid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tDoc = tDoc;
        this.doc = doc;
        this.direccion = direccion;
    }

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

    public String gettDoc() {
        return tDoc;
    }

    public void settDoc(String tDoc) {
        this.tDoc = tDoc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
