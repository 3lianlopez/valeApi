package com.holamundo.holamundo.services;

import com.holamundo.holamundo.entities.ClientEntity;
import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.models.ErrorDetail;
import com.holamundo.holamundo.models.ResponseBody;
import com.holamundo.holamundo.repository.ClientRepository;
import com.holamundo.holamundo.repository.MapperClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;


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

        MapperClient mapperClient = new MapperClient();

        ClientEntity clientEntity = mapperClient.dtoToEntity(client);

        ClientEntity clienteGuardado = clientRepository.save(clientEntity);
        ClientDTO clientDTO = mapperClient.entityToDto(clienteGuardado);
        return new ResponseBody(clientDTO,null, HttpStatus.CREATED.value());
        }catch (IllegalArgumentException e){
            log.info("Error: " + e);
            return new ResponseBody(null,new ErrorDetail("VALIDATION_ERROR", e.getMessage()),HttpStatus.BAD_REQUEST.value());
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
    public ClientEntity getById(UUID uuid) {
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
    public Optional<ClientEntity> findById(UUID uuid) {
        return Optional.empty();
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
}
