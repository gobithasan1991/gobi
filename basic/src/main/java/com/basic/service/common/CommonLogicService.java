package com.basic.service.common;

import com.basic.persitance.model.common.Default;

public interface CommonLogicService { 
	public <T extends Default> T commonUpdate(T entity, Class<T> entityClass);
	public <T extends Default> T commonDelete(T entity, Class<T> entityClass);
}
