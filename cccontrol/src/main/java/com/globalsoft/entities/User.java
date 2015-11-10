package com.globalsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.globalsoft.util.Messages;

@Entity
@Table(name="users")
public class User extends Person implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = -741285610096169743L;

	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Boolean validate() throws Exception {
		super.validate();
		if (login == null || login.isEmpty()) {
			throw new Exception(Messages.INVALID_LOGIN);
		}
		if (password == null || password.isEmpty()) {
			throw new Exception(Messages.INVALID_PASSWORD);
		}
		return Boolean.TRUE;
	}
}