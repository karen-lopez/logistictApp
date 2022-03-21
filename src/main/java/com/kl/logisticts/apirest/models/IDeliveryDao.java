package com.kl.logisticts.apirest.models;

import com.kl.logisticts.apirest.entitys.delivery.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDeliveryDao extends MongoRepository<Delivery, String>{
    
}
