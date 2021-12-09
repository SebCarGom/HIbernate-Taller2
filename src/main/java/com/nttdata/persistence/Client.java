package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NTTDATA_CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	private Long clientId;
	private String clientName;
	private String clientFirstSurname;
	private String clientSecondSurname;
	private String nationalIdentityDocument;
	private List<Contract> contractList;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientName
	 */
	@Column(name = "C_CLIENT_NAME")
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientFirstSurname
	 */
	@Column(name = "C_CLIENT_FIRST_SURNAME")
	public String getClientFirstSurname() {
		return clientFirstSurname;
	}

	/**
	 * @param clientFirstSurname
	 *            the clientFirstSurname to set
	 */
	public void setClientFirstSurname(String clientFirstSurname) {
		this.clientFirstSurname = clientFirstSurname;
	}

	/**
	 * @return the clientSecondSurname
	 */
	@Column(name = "C_CLIENT_SECOND_SURNAME")
	public String getClientSecondSurname() {
		return clientSecondSurname;
	}

	/**
	 * @param clientSecondSurname
	 *            the clientSecondSurname to set
	 */
	public void setClientSecondSurname(String clientSecondSurname) {
		this.clientSecondSurname = clientSecondSurname;
	}

	/**
	 * @return the nationalIdentityDocument
	 */
	@Column(name = "C_NATIONAL_IDENTITY_DOCUMENT", nullable = false, unique = true, length = 9)
	public String getNationalIdentityDocument() {
		return nationalIdentityDocument;
	}

	/**
	 * @param nationalIdentityDocument
	 *            the nationalIdentityDocument to set
	 */
	public void setNationalIdentityDocument(String nationalIdentityDocument) {
		this.nationalIdentityDocument = nationalIdentityDocument;
	}

	/**
	 * @return the contractList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList
	 *            the contractList to set
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	@Transient
	public Class<?> getClassT() {
		return Client.class;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientFirstSurname=" + clientFirstSurname + ", clientSecondSurname="
		        + clientSecondSurname + ", nationalIdentityDocument=" + nationalIdentityDocument;
	}

}