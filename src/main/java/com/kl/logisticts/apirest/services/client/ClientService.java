package com.kl.logisticts.apirest.services.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kl.logisticts.apirest.entitys.Client;
import com.kl.logisticts.apirest.models.IClientDao;

@Service
public class ClientService implements IClientService{

	@Autowired
	private IClientDao clientDao;
	
	@Override
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Override
	public Client findById(String id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public Client save(Client client) {
		return clientDao.save(client);
	}

	@Override
	public void deleteById(String documentNumber) {
                Client client = clientDao.findById(documentNumber).orElse(null);
		if(client != null){
                    clientDao.delete(client);
                }
	}

}
