package com.kl.logisticts.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kl.logisticts.apirest.services.client.IClientService;
import com.kl.logisticts.apirest.entitys.Client;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	IClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> list(){
		return clientService.findAll();
	}
	
	@GetMapping("/client/{documentNumber}")
	public Client findById(@PathVariable String documentNumber) {
		return clientService.findById(documentNumber);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/clients")
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	}
        
        @DeleteMapping("/client/{id}")
        void delete(@PathVariable String id){
            clientService.deleteById(id);
        }
        
}
