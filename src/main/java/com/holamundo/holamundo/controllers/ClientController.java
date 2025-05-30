package com.holamundo.holamundo.controllers;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.models.ResponseBody;
import com.holamundo.holamundo.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    //simulacion de una base de datos en memoria
    private final Map<UUID, ClientDTO> clients = new ConcurrentHashMap<>();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clientes",method = RequestMethod.POST)
    public ResponseBody crearPersona(@RequestBody ClientDTO clienteNuevo){
        return clientService.createClient(clienteNuevo);
    }






}
