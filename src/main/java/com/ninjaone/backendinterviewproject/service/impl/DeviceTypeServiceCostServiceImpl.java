/**
 * 
 */
package com.ninjaone.backendinterviewproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.DeviceTypeServiceCostRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCost;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCostPK;
import com.ninjaone.backendinterviewproject.service.DeviceTypeServiceCostService;

/**
 * @author Sebastian
 *
 */
@Service
public class DeviceTypeServiceCostServiceImpl extends CRUDImpl<DeviceTypeServiceCost, DeviceTypeServiceCostPK>
		implements DeviceTypeServiceCostService {
	
	@Autowired
	private DeviceTypeServiceCostRepository repo;

	@Override
	protected IGenericRepo<DeviceTypeServiceCost, DeviceTypeServiceCostPK> getRepo() {
		return this.repo;
	}

	@Override
	public DeviceTypeServiceCost findOneByDeviceTypeAndDeviceService(DeviceType deviceType,
			DeviceService deviceService) {
		return this.repo.findOneByDeviceTypeAndDeviceService(deviceType, deviceService);
	}

}
