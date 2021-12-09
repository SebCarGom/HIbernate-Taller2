package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.ClientDaoI;
import com.nttdata.persistence.ClientDaoImpl;

public class ClientServiceImpl implements ClientServiceI{

	private ClientDaoI clientDao;
	
	public ClientServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}
	
	@Override
	public void addClient(Client newClient) {
		
		clientDao.insert(newClient);
		
	}

	@Override
	public Client findClientById(Long idToSearch) {
		return clientDao.searchById(idToSearch);
	}

	@Override
	public List<Client> findAllClientsFromSystem() {
		
		return clientDao.searchAll();
	}

	@Override
	public void delete(Client removeClient) {
		clientDao.delete(removeClient);
		
	}

	@Override
	public void update(Client updateClient) {
		clientDao.update(updateClient);
		
	}

}