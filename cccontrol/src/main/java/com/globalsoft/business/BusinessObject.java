package com.globalsoft.business;

import com.globalsoft.dao.DAO;
import com.globalsoft.entities.Entity;

public interface BusinessObject<T extends Entity> extends DAO<T> {}
