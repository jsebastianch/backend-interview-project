/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCost;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCostPK;

/**
 * @author Sebastian
 *
 */
public interface DeviceTypeServiceCostService extends ICRUD<DeviceTypeServiceCost, DeviceTypeServiceCostPK> {
	DeviceTypeServiceCost findOneByDeviceTypeAndDeviceService(DeviceType deviceType, DeviceService deviceService);
}
