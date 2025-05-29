package com.holamundo.holamundo.controllers;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private final ClientService clientService;

    //simulacion de una base de datos en memoria
    private final Map<UUID, ClientDTO> clients = new ConcurrentHashMap<>();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /*@GetMapping
    public ResponseEntity<Map<String,Object>> obtenerPersonas(){
        Map<String,Object> responseBody = new HashMap<>();
        List<ClientDTO> clientes = new ArrayList<>();
        clientes = clientService.findAllClients();
        responseBody.put("body",clientes);
        responseBody.put("statusCode",HttpStatus.OK.value());
        responseBody.put("mensaje","Se obtiene información por el metodo GET");

        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Map<String,Object>> obtenerPorId(@PathVariable UUID uuid){
        Optional<ClientDTO> cliente = clientService.getClientById(uuid);
        Map<String,Object> responseBody = new HashMap<>();
        if(cliente.isPresent()){
            responseBody.put("body",cliente);
            responseBody.put("statusCode",HttpStatus.OK.value());
            responseBody.put("mensaje","SE OBTIENE INFORMACION POR METODO GET POR uuid");
            return new ResponseEntity<>(responseBody,HttpStatus.OK);
        }else{
            responseBody.put("body","METODO GET/{uuid}");
            responseBody.put("statusCode",HttpStatus.FOUND.value());
            responseBody.put("mensaje","No es encontro nada por el uuid");
            return new ResponseEntity<>(responseBody,HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping
    public ResponseEntity<Map<String,Object>> crearPersona(@RequestBody ClientDTO clienteNuevo, UriComponentsBuilder ucb){
        clientService.createClient(clienteNuevo);
        
        Map<String,Object> responseBody = new HashMap<>();

        responseBody.put("body",clienteNuevo);
        responseBody.put("statusCode",HttpStatus.CREATED.value());
        responseBody.put("mensaje","MENTODO POST");

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{uuid}")
    public ResponseEntity<Map<String,Object>> actualizarPersona(@PathVariable UUID uuid,@RequestBody ClientDTO clienteActualizado){

        Map<String,Object> responseBody = new HashMap<>();

        clientService.updateClientById(uuid,clienteActualizado);
        responseBody.put("body",clienteActualizado);
        responseBody.put("statusCode",HttpStatus.CREATED.value());
        responseBody.put("mensaje","METODO PUT");

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);

    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Map<String,Object>> eliminarPersona(@PathVariable UUID uuid){
        Map<String,Object> responseBody = new HashMap<>();
        Optional<ClientDTO> cliente = clientService.getClientById(uuid);
        if(cliente.isPresent()){
            clientService.deleteClient(uuid);
            responseBody.put("body","SE HA ELIMINADO");
            responseBody.put("statusCode",HttpStatus.NO_CONTENT.value());
            responseBody.put("mensaje","METODO DELETE");

            return new  ResponseEntity<>(responseBody,HttpStatus.NO_CONTENT);
        }else{
            responseBody.put("body","NO SE HA ENCONTRADO ELEMENTO PARA ELIMINAR");
            responseBody.put("statusCode",HttpStatus.NOT_FOUND.value());
            responseBody.put("mensaje","METODO DELETE");
            return new ResponseEntity<>(responseBody,HttpStatus.NOT_FOUND);
        }
    }*/



}
