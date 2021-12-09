package com.nttdata.persistence;

import org.hibernate.Session;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	private Session session;

	public ContractDaoImpl(final Session session) {
		super(session);
		this.session = session;
	}

}