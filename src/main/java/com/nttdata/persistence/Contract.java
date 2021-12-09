package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NTTDATA_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	private Long contractId;
	private Date contractEffectiveDate;
	private Date contractExpirationDate;
	private Double contractMonthlyPay;
	private Client client;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId
	 *            the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the contractEffectiveDate
	 */
	@Column(name = "C_CONTRACT_EFFECTIVE_DATE")
	public Date getContractEffectiveDate() {
		return contractEffectiveDate;
	}

	/**
	 * @param contractEffectiveDate
	 *            the contractEffectiveDate to set
	 */
	public void setContractEffectiveDate(Date contractEffectiveDate) {
		this.contractEffectiveDate = contractEffectiveDate;
	}

	/**
	 * @return the contractExpirationDate
	 */
	@Column(name = "C_CONTRACT_EXPIRATION_DATE")
	public Date getContractExpirationDate() {
		return contractExpirationDate;
	}

	/**
	 * @param contractExpirationDate
	 *            the contractExpirationDate to set
	 */
	public void setContractExpirationDate(Date contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}

	/**
	 * @return the contractMonthlyPay
	 */
	@Column(name = "C_CONTRACT_MONTHLY_PAY")
	public Double getContractMonthlyPay() {
		return contractMonthlyPay;
	}

	/**
	 * @param contractMonthlyPay
	 *            the contractMonthlyPay to set
	 */
	public void setContractMonthlyPay(Double contractMonthlyPay) {
		this.contractMonthlyPay = contractMonthlyPay;
	}

	/**
	 * @return the client
	 */
	@ManyToOne
	@JoinColumn(name = "C_CLIENT_ID_FK")
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractEffectiveDate=" + contractEffectiveDate + ", contractExpirationDate=" + contractExpirationDate
		        + ", contractMonthlyPay=" + contractMonthlyPay + ", client=" + client + "]";
	}

}