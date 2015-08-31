package com.globalsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.globalsoft.util.Constants;
import com.globalsoft.util.Messages;

@Entity
@Table(name = "User")
public class User implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = -741285610096169743L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name="removed")
	private Boolean removed;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = true)
	private Date updateDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_date", nullable = true)
	private Date removeDate;

	@OneToOne
	@JoinColumn(name="create_user_id")
	private User createUser;
	@OneToOne
	@JoinColumn(name="update_user_id")
	private User updateUser;
	@OneToOne
	@JoinColumn(name="remove_user_id")
	private User removeUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	public User getRemoveUser() {
		return removeUser;
	}
	public void setRemoveUser(User removeUser) {
		this.removeUser = removeUser;
	}
	public Boolean isRemoved() {
		return removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
	@Override
	public Boolean validate() throws Exception {
		if (cpf == null || cpf.isEmpty() || cpf.length() != 11 || !cpf.matches(Constants.CPF_REGEX) ) {
			throw new Exception(Messages.INVALID_CPF);
		}
		if (name == null || name.isEmpty()) {
			throw new Exception(Messages.INVALID_NAME);
		}
		if (login == null || login.isEmpty()) {
			throw new Exception(Messages.INVALID_LOGIN);
		}
		if (password == null || password.isEmpty()) {
			throw new Exception(Messages.INVALID_PASSWORD);
		}
		return Boolean.TRUE;
	}
}