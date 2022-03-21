package com.kl.logisticts.apirest.services.delivery;

import com.kl.logisticts.apirest.entitys.Client;
import com.kl.logisticts.apirest.entitys.delivery.Delivery;
import com.kl.logisticts.apirest.models.IClientDao;
import com.kl.logisticts.apirest.models.IDeliveryDao;
import com.kl.logisticts.apirest.models.IProductDao;
import static com.kl.logisticts.apirest.validations.Validation.validateNotNull;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements IDeliveryService{
    
    @Autowired
    IDeliveryDao deliveryDao;
    @Autowired
    IClientDao clientDao;
    @Autowired
    IProductDao productDao;

    @Override
    public List<Delivery> findAll() {
        return (List<Delivery>) deliveryDao.findAll();
    }

    @Override
    public Delivery findById(String id) {
        return deliveryDao.findById(id).orElse(null);
    }

    @Override
    public Delivery save(Delivery delivery) {
        Client client = clientDao.findById(delivery.getClientId()).orElse(null);
        validateNotNull(client, "Client No Found");
        return deliveryDao.save(delivery);
    }
    
}
