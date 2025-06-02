package com.holamundo.holamundo.controllers;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.services.ClientServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api")
public class ClientController {


    private final ClientServicesImpl clientService;
    public ClientController(ClientServicesImpl clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clientes",method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> crearCliente(@RequestBody ClientDTO clienteNuevo)  {

        log.info("CLIENTE NUEVO : "+clienteNuevo.toString());
        return clientService.createClient(clienteNuevo);
    }

    @RequestMapping(value = "/clientes",method = RequestMethod.GET)
    public List<ClientDTO> listsClients()  {


        return  clientService.getAllClients();
    }

}
