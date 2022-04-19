package com.ninjaone.backendinterviewproject.database;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCost;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCostPK;

@Repository
public interface DeviceTypeServiceCostRepository extends IGenericRepo<DeviceTypeServiceCost, DeviceTypeServiceCostPK> {

	DeviceTypeServiceCost findOneByDeviceTypeAndDeviceService(DeviceType deviceType, DeviceService deviceService);
}
