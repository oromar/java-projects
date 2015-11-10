package com.globalsoft.entities;

import javax.persistence.Column;
import javax.persistence.Table;

import com.globalsoft.util.Messages;

@javax.persistence.Entity
@Table(name="client")
public class Client extends BasicEntity {
	
	private static final long serialVersionUID = 4369234874072181751L;
	@Column(name="phone")
	private String phone;
	@Column(name="observations")
	private String observations;

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public Boolean validate() throws Exception {
		if (phone == null || phone.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		if (observations == null || observations.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		return Boolean.TRUE;
	}
}
