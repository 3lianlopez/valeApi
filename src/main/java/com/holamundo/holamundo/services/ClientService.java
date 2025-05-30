package com.holamundo.holamundo.services;

import com.holamundo.holamundo.models.ClientDTO;
import com.holamundo.holamundo.models.ResponseBody;


public interface ClientService {

     ResponseBody createClient(ClientDTO client);

}

