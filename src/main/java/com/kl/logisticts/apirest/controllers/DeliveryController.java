package com.kl.logisticts.apirest.controllers;

import com.kl.logisticts.apirest.entitys.delivery.Delivery;
import com.kl.logisticts.apirest.services.delivery.IDeliveryService;
import com.kl.logisticts.apirest.entitys.delivery.RoadDelivery;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    IDeliveryService deliveryService;

    @GetMapping("/deliverys")
    public List<Delivery> list() {
        return deliveryService.findAll();
    }

    @PostMapping("/roadDeliverys")
    public Delivery save(@RequestBody RoadDelivery delivery, HttpServletResponse response) {
        return deliveryService.save(delivery);
    }
    
     @GetMapping("/delivery/{id}")
    public Delivery findById(@PathVariable String id){
        return deliveryService.findById(id);
    }
}
