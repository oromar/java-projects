package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import com.globalsoft.util.Messages;

@javax.persistence.Entity
@DiscriminatorValue(value="client")
public class Client extends Person implements Entity, Serializable {
	
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
	
	@Override
	public Boolean validate() throws Exception {
		super.validate();
		if (phone == null || phone.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		if (observations== null || observations.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		return Boolean.TRUE;
	}
}
