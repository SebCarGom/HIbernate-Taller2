package com.nttdata.client;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import com.nttdata.persistence.Client;
import com.nttdata.persistence.Contract;
import com.nttdata.services.ClientServiceI;
import com.nttdata.services.ClientServiceImpl;
import com.nttdata.services.ContractServiceI;
import com.nttdata.services.ContractServiceImpl;

public class ClientApp {
	public static void main(String[] args) {
		final Session session = ClientSessionUtil.getSessionFactory().openSession();

		final ClientServiceI clientService = new ClientServiceImpl(session);
		final ContractServiceI contractService = new ContractServiceImpl(session);

		final Client daniel = new Client();
		daniel.setNationalIdentityDocument("39684521A");
		daniel.setClientName("Daniel");
		daniel.setClientFirstSurname("Trujillo");
		daniel.setClientSecondSurname("Trasmonte");
		daniel.setUpdatedDate(new Date());
		daniel.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(daniel);

		final Client ana = new Client();
		ana.setNationalIdentityDocument("34127534A");
		ana.setClientName("Ana");
		ana.setClientFirstSurname("Trujillo");
		ana.setClientSecondSurname("Trasmonte");
		ana.setUpdatedDate(new Date());
		ana.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(ana);

		final Client victoria = new Client();
		victoria.setNationalIdentityDocument("32156321A");
		victoria.setClientName("Victoria");
		victoria.setClientFirstSurname("Trujillo");
		victoria.setClientSecondSurname("Trasmonte");
		victoria.setUpdatedDate(new Date());
		victoria.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(victoria);

		final Contract work1 = new Contract();
		work1.setClient(daniel);
		work1.setContractEffectiveDate(new Date());
		work1.setContractMonthlyPay(1240.12);
		work1.setUpdatedDate(new Date());
		work1.setUpdatedUser("scarnero.nttdata");

		final Contract work2 = new Contract();
		work2.setClient(ana);
		work2.setContractEffectiveDate(new Date());
		work2.setContractMonthlyPay(4902.80);
		work2.setUpdatedDate(new Date());
		work2.setUpdatedUser("scarnero.nttdata");

		final Contract work3 = new Contract();
		work3.setClient(victoria);
		work3.setContractEffectiveDate(new Date());
		work3.setContractMonthlyPay(1300.50);
		work3.setUpdatedDate(new Date());
		work3.setUpdatedUser("scarnero.nttdata");

		final Contract work4 = new Contract();
		work4.setClient(daniel);
		work4.setContractEffectiveDate(new Date());
		work4.setContractMonthlyPay(940.12);
		work4.setUpdatedDate(new Date());
		work4.setUpdatedUser("scarnero.nttdata");

		contractService.addContract(work1);
		contractService.addContract(work2);
		contractService.addContract(work3);
		contractService.addContract(work4);
		final Client searchClient = clientService.findClientById(1L);
		System.out.println(searchClient);

		final Contract searchContract = contractService.findContractById(5L);
		System.out.println(searchContract);

		final List<Client> clienstList = clientService.findAllClientsFromSystem();
		if (clienstList != null && clienstList.size() > 0) {
			System.out.println("Total clientes: " + clienstList.size());
			for (final Client client : clienstList) {
				System.out.println(client.toString() + "\n");
			}
		}

		final List<Contract> contractsList = contractService.findAllContractsFromSystem();
		if (contractsList != null && contractsList.size() > 0) {
			System.out.println("Contratos registrados: " + contractsList.size());
			for (Contract contract : contractsList) {
				System.out.println(contract.toString() + "\n");
			}
		}

		session.close();
	}
}