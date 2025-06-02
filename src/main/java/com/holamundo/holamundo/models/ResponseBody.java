package com.holamundo.holamundo.models;

import com.holamundo.holamundo.entities.ClientEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class ResponseBody{
    // Getters and Setters
    private ClientDTO data;
    private ErrorDetail error;
    private int status;
    private Instant timestamp;

    // Constructores
    public ResponseBody(ClientDTO data, ErrorDetail error, int status) {
        this.data = data;
        this.error = error;
        this.status = status;
        this.timestamp = Instant.now();
    }

}
