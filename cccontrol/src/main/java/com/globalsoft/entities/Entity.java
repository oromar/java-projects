package com.globalsoft.entities;

public interface Entity {
	
	Long getId();
	Boolean validate() throws Exception;
	Boolean isRemoved() throws Exception;
	void setRemoved(Boolean removed) throws Exception;

}
