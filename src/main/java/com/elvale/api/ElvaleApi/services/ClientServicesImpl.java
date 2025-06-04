package com.elvale.api.ElvaleApi.services;


import com.elvale.api.ElvaleApi.entities.ClientEntity;
import com.elvale.api.ElvaleApi.models.ClientDTO;
import com.elvale.api.ElvaleApi.repository.ClientRepository;
import com.elvale.api.ElvaleApi.repository.MapperClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;


@Service
public class ClientServicesImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServicesImpl.class);
    private final ClientRepository clientRepository;
    MapperClient mapperClient = new MapperClient();


    public ClientServicesImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<ClientDTO> createClient(ClientDTO client){
        try {
        log.info("Creando nuevo cliente: {}", client);


        ClientEntity clientEntity = mapperClient.dtoToEntity(client);

        ClientEntity clienteGuardado = clientRepository.save(clientEntity);
        ClientDTO clientDTO = mapperClient.entityToDto(clienteGuardado);
        return ResponseEntity.ok(clientDTO);
        }catch (IllegalArgumentException e){
            log.info("Error: " + e);
            return ResponseEntity.badRequest().build();
        }

    }

    public List<ClientDTO> getAllClients(){
        try {
            return clientRepository.findAll().stream()
                    .map(client -> new ClientDTO(
                            client.getUuid(),
                            client.getNombres(),
                            client.getApellidos(),
                            client.getTipoDocumento(),
                            client.getDocumento(),
                            client.getDireccion()))
                    .toList();

        }catch (Exception e){
                   log.info(e.getMessage());
           return null;
        }
    }



    public ResponseEntity<ClientDTO> getClientByUuid(UUID uuid) {
        try {
            Optional<ClientEntity> clientEntity = clientRepository.findById(uuid);
            if (clientEntity.isPresent()) {
                ClientDTO clientDTO = mapperClient.entityToDto(clientEntity.get());
                return ResponseEntity.ok(clientDTO);
            } else {
                log.info("Cliente no encontrado con UUID: {}", uuid);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Error al buscar cliente por UUID: {}", uuid, e);
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<ClientDTO> updateClientByUuid(UUID uuid, ClientDTO client) {
        try {
            Optional<ClientEntity> existingClient = clientRepository.findById(uuid);
            if (existingClient.isPresent()) {
                ClientEntity clientEntity = mapperClient.dtoToEntity(client);
                clientEntity.setUuid(uuid); // Ensure the UUID is set
                ClientEntity updatedClient = clientRepository.save(clientEntity);
                ClientDTO updatedClientDTO = mapperClient.entityToDto(updatedClient);
                return ResponseEntity.ok(updatedClientDTO);
            } else {
                log.info("Cliente no encontrado con UUID: {}", uuid);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Error al actualizar cliente con UUID: {}", uuid, e);
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<Void> deleteClientByUuid(UUID uuid) {
        try {
            if (clientRepository.existsById(uuid)) {
                clientRepository.deleteById(uuid);
                return ResponseEntity.noContent().build();
            } else {
                log.info("Cliente no encontrado con UUID: {}", uuid);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Error al eliminar cliente con UUID: {}", uuid, e);
            return ResponseEntity.status(500).build();
        }
    }




    @Override
    public void flush() {

    }

    @Override
    public <S extends ClientEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ClientEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<ClientEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ClientEntity getOne(UUID uuid) {
        return null;
    }

   

    @Override
    public ClientEntity getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends ClientEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ClientEntity> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends ClientEntity> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends ClientEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ClientEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ClientEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ClientEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ClientEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientEntity> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

   

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<ClientEntity> findAll() {
        return List.of();
    }

    @Override
    public List<ClientEntity> findAllById(Iterable<UUID> uuids) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(ClientEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClientEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ClientEntity> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<ClientEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ClientEntity getById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Optional<ClientEntity> findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
