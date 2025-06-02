package com.holamundo.holamundo.controllers;

import com.holamundo.holamundo.entities.ClientEntity;
import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.models.ResponseBody;
import com.holamundo.holamundo.repository.MapperClient;
import com.holamundo.holamundo.services.ClientServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api")
public class ClientController {


    private final ClientServicesImpl clientService;
    public ClientController(ClientServicesImpl clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clientes",method = RequestMethod.POST)
    public ResponseBody crearCliente(@RequestBody ClientDTO clienteNuevo)  {

        log.info("CLIENTE NUEVO : "+clienteNuevo.toString());
        ResponseBody responseBody = clientService.createClient(clienteNuevo);

        return new ResponseBody(responseBody.getData(),null, HttpStatus.OK.value());
    }

}
