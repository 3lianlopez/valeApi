package com.elvale.api.ElvaleApi.services;

import com.elvale.api.ElvaleApi.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ClientService extends JpaRepository<ClientEntity, UUID> {


}

