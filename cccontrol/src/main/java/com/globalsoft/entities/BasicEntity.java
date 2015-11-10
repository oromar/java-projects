package com.globalsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BasicEntity implements com.globalsoft.entities.Entity, Serializable {

	private static final long serialVersionUID = -5095652215891982707L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
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
	public Boolean isRemoved() {
		return removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public User getRemoveUser() {
		return removeUser;
	}
	public void setRemoveUser(User removeUser) {
		this.removeUser = removeUser;
	}
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
}
