package com.globalsoft.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BasicEntity {

	private static final long serialVersionUID = -1385928286137454444L;

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean validate() throws Exception {
		return null;
	}
	@Override
	public String toString() {
		return name;
	}
}
