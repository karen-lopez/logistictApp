package com.kl.logisticts.apirest.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kl.logisticts.apirest.entitys.Client;

public interface IClientDao extends MongoRepository<Client, String>{

}
