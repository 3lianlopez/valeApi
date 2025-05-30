package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.models.ErrorDetail;
import com.holamundo.holamundo.models.ResponseBody;
import com.holamundo.holamundo.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ClientServicesImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServicesImpl.class);
    private final ClientRepository clientRepository;


    public ClientServicesImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseBody createClient(ClientDTO client){
        try {
        log.info("Creando nuevo cliente: {}", client);
        validatorClients(client);
        ClientDTO clientDTO = clientRepository.createClient(client);
        return new ResponseBody(clientDTO,null, HttpStatus.CREATED.value());
        }catch (IllegalArgumentException e){
            log.info("Error: " + e);
            return new ResponseBody(null,new ErrorDetail("VALIDATION_ERROR", e.getMessage()),HttpStatus.BAD_REQUEST.value());
        }

    }

    private void validatorClients(ClientDTO client) {
        if (client.getApellidos() == null && isValidString(client.getApellidos())) {
            throw new IllegalArgumentException("Apelledos son requeridos");
        }

        if (client.getNombres() == null || client.getNombres().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombres son requeridos");
        }

        if (client.getDocumento() == null || client.getDocumento().isEmpty() ){
            throw new IllegalArgumentException("Documento es requerido");
        }

        if (client.getTipoDocumento() == null || client.getTipoDocumento().isEmpty() ){
            throw new IllegalArgumentException("Tipo de documento es requerido");
        }

        if (client.getDireccion() == null || client.getDireccion().isEmpty() ){
            throw new IllegalArgumentException("Dirección es requerida");
        }

        if(isValidString(client.getTipoDocumento())){
            throw new IllegalArgumentException("Tipo de documento debe ser solo letras");
        }

        if ( isNumeric(client.getDocumento())){
            throw new IllegalArgumentException("Documento debe ser solo numero");
        }

    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public static boolean isValidString(String str) {
        return str.matches("^[a-zA-Z]+$");
    }


}
