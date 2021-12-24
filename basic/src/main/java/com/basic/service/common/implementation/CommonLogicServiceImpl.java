package com.basic.service.common.implementation;

import org.springframework.stereotype.Service;

import com.basic.extensible.CurrentStatus;
import com.basic.extensible.RecordStatus;
import com.basic.persitance.model.common.Default;
import com.basic.service.common.CommonLogicService;
@Service
public class CommonLogicServiceImpl implements CommonLogicService{

	@Override
	public <T extends Default> T commonUpdate(T entity, Class<T> entityClass) {
		entity.setRecordStatus(RecordStatus.UPDATED);
		return entity;
	}

	@Override
	public <T extends Default> T commonDelete(T entity, Class<T> entityClass) {
		entity.setRecordStatus(RecordStatus.DELETED);
		entity.setCurrentStatus(CurrentStatus.DELETED);
		return entity;
	}

}
