package com.kl.logisticts.apirest.services.delivery;

import com.kl.logisticts.apirest.entitys.delivery.Delivery;
import java.util.List;

public interface IDeliveryService {
    List<Delivery> findAll();
    Delivery findById(String id);
    Delivery save(Delivery delivery);
}
