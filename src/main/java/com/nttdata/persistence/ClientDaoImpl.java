package com.nttdata.persistence;

import org.hibernate.Session;

public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	private Session session;

	public ClientDaoImpl(final Session session) {
		super(session);
		this.session = session;
	}

}