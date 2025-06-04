package com.elvale.api.ElvaleApi.controllers;

import com.elvale.api.ElvaleApi.models.ClientDTO;
import com.elvale.api.ElvaleApi.services.ClientServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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

 log.info("Consultando clientes : ");
        return  clientService.getAllClients();
    }

    @RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> getClientByUuid(@PathVariable UUID uuid)  {

        log.info("Consultando cliente por uuid : "+uuid);
        return clientService.getClientByUuid(uuid);
    }

    @RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClientByUuid(@PathVariable UUID uuid)  {

        log.info("Eliminando cliente por uuid : "+uuid);
        return clientService.deleteClientByUuid(uuid);
    }

    @RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.PUT)
    public ResponseEntity<ClientDTO> updateClientByUuid(@PathVariable UUID uuid, @RequestBody ClientDTO client)  {

        log.info("Actualizando cliente por uuid : "+uuid);
        return clientService.updateClientByUuid(uuid, client);
    }


}
