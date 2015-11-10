package com.globalsoft.entities;

import javax.persistence.Column;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@javax.persistence.Entity
public abstract class Person extends BasicEntity  {

	private static final long serialVersionUID = -3842576486170252907L;
	
	@Column(name="name")
	private String name;
	@Column(name="cpf")
	private String cpf;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
	public Boolean validate() throws Exception {
		if (cpf == null || cpf.isEmpty() || cpf.length() != 11 || !cpf.matches(Constants.CPF_REGEX) ) {
			throw new Exception(Messages.INVALID_CPF);
		}
		if (name == null || name.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		return Boolean.TRUE;
	}
}
