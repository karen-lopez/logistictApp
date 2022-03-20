package com.kl.logisticts.apirest.services.client;

import java.util.List;

import com.kl.logisticts.apirest.entitys.Client;

public interface IClientService {
	List<Client> findAll();
	Client findById(String id);
	Client save(Client client);
	void deleteById(String documentNumber);
}
