package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contract;

public interface ContractServiceI {

	public void addContract(final Contract newClient);

	public Contract findContractById(final Long idToSearch);

	public List<Contract> findAllContractsFromSystem();

	public void deleteContract(final Contract removeContract);

	public void updateContract(final Contract updateContract);
}