package com.globalsoft.entities;

import java.util.Date;

public interface Entity {
	
	Long getId();
	Boolean validate() throws Exception;
	Boolean isRemoved() throws Exception;
	void setRemoved(Boolean removed) throws Exception;
	void setCreateDate(Date createDate);
	void setUpdateDate(Date updateDate);
	void setRemoveDate(Date removeDate);
	void setCreateUser(User createUser) ;
	void setUpdateUser(User updateUser);
	void setRemoveUser(User removeUser) ;

}
