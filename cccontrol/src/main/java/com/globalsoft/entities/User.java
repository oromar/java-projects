package com.globalsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
	@Column(name="born_date")
	private Date bornDate;
	@OneToOne
	private Role role;

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
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
		if (bornDate == null) {
			throw new Exception(Messages.INVALID_DATE);
		}
		
		return Boolean.TRUE;
	}
}