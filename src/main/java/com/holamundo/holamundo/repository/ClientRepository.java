package com.holamundo.holamundo.repository;

import com.holamundo.holamundo.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,UUID> {

}
