package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Contract;
import com.nttdata.persistence.ContractDaoI;
import com.nttdata.persistence.ContractDaoImpl;

public class ContractServiceImpl implements ContractServiceI {

	private ContractDaoI contractDao;

	public ContractServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void addContract(final Contract newClient) {

		contractDao.insert(newClient);
	}

	@Override
	public Contract findContractById(Long idToSearch) {

		return contractDao.searchById(idToSearch);
	}

	@Override
	public List<Contract> findAllContractsFromSystem() {

		return contractDao.searchAll();
	}

	@Override
	public void deleteContract(Contract removeContract) {
		contractDao.delete(removeContract);

	}

	@Override
	public void updateContract(Contract updateContract) {
		contractDao.update(updateContract);

	}

}