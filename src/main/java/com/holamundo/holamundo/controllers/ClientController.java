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


// Falta agregar documentacion javadoc

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

  
    @Autowired
    private ClientService clientService; //Convertir a interface y lo que esta actual cambiarlo a un archivo de implementacion


    //simulacion de una base de datos en memoria
    private final Map<UUID, ClientDTO> clients = new ConcurrentHashMap<>();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /*@GetMapping//adicionar identificador al get dado que si se requiere otro get no se puede hacer porque se esta usando el mismo endpoint
    //@RequestMapping(value = "/clientes",method = RequestMethod.GET)
    
    public ResponseEntity<Map<String,Object>> obtenerPersonas(){
        Map<String,Object> responseBody = new HashMap<>();
        List<ClientDTO> clientes = new ArrayList<>();
        clientes = clientService.findAllClients();
        responseBody.put("body",clientes);
        responseBody.put("statusCode",HttpStatus.OK.value());
        responseBody.put("mensaje","Se obtiene información por el metodo GET");

        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    @GetMapping("/{uuid}")//adicionar identificador al get dado que si se requiere otro get no se puede hacer porque se esta usando el mismo endpoint
    //@RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.GET)
    //eñl parametro de entrada deberia ser un Dto
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
    //@RequestMapping(value = "/clientes",method = RequestMethod.POST)
    //esta sobrando el parametro UriComponentsBuilder
    public ResponseEntity<Map<String,Object>> crearPersona(@RequestBody ClientDTO clienteNuevo){
        clientService.createClient(clienteNuevo);
        
        Map<String,Object> responseBody = new HashMap<>();

        //Construir URI del nuevo recurso
        // esto para que?
        HttpHeaders headers = new HttpHeaders();
        responseBody.put("body",clienteNuevo);
        responseBody.put("statusCode",HttpStatus.CREATED.value());
        responseBody.put("mensaje","MENTODO POST");

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{uuid}")
    //@RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.PUT)
    //el parametro de entrada deberia ser un Dto
    //EL METODO ES ACTUALIZAR CLIENTE NO PERSONA    
    //@PathVariable UUID uuid,@RequestBody ClientDTO clienteActualizado esto no lo entiendo
    public ResponseEntity<Map<String,Object>> actualizarPersona(@PathVariable UUID uuid,@RequestBody ClientDTO clienteActualizado){

        Map<String,Object> responseBody = new HashMap<>();

        clientService.updateClientById(uuid,clienteActualizado);
        responseBody.put("body",clienteActualizado);
        responseBody.put("statusCode",HttpStatus.CREATED.value());
        responseBody.put("mensaje","METODO PUT");

        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);

    }

    @DeleteMapping("/{uuid}")
    //@RequestMapping(value = "/clientes/{uuid}",method = RequestMethod.DELETE)
    //el parametro de entrada deberia ser un Dto
    public ResponseEntity<Map<String,Object>> eliminarPersona(@PathVariable UUID uuid){
        //el controlador no debe de tener logica de negocio
        //el servicio debe de tener la logica de negocio

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
