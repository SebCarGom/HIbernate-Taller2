package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Usuario que actualiza el registro */
	private String updatedUser;

	/** Auditoria - Fecha en que se actualiza el registro */
	private Date updatedDate;

	/**
	 * @return the updatedUser
	 */
	@Column(name = "C_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser
	 *            the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "C_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}