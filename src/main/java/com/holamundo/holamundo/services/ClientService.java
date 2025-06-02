package com.holamundo.holamundo.services;

import com.holamundo.holamundo.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ClientService extends JpaRepository<ClientEntity, UUID> {


}

