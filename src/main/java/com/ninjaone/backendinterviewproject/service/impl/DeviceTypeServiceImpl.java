package com.ninjaone.backendinterviewproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.DeviceTypeRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.DeviceTypeService;

@Service
public class DeviceTypeServiceImpl extends CRUDImpl<DeviceType, Integer> implements DeviceTypeService {
	
	@Autowired
	private DeviceTypeRepository repo;

	@Override
	protected IGenericRepo<DeviceType, Integer> getRepo() {
		return this.repo;
	}


}
