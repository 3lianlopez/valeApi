package com.holamundo.holamundo.models;

import java.time.Instant;

public class ResponseBody {
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

    // Getters and Setters
    public ClientDTO getData() {
        return data;
    }

    public void setData(ClientDTO data) {
        this.data = data;
    }

    public ErrorDetail getError() {
        return error;
    }

    public void setError(ErrorDetail error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
