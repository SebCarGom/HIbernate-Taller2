package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Client;

public interface ClientServiceI {

	public void addClient(final Client newClient);

	public Client findClientById(final Long idToSearch);

	public List<Client> findAllClientsFromSystem();

	public void delete(final Client removeClient);

	public void update(final Client updateClient);

}