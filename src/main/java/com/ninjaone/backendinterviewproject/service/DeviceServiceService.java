/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.DeviceService;

/**
 * @author sebas
 *
 */
public interface DeviceServiceService extends ICRUD<DeviceService, Integer>{
	
	/**
	 * Creates a device service.
	 * @param deviceService the service to be created
	 * @return the created service
	 * @throws Exception if the service already exists
	 */
	public DeviceService insertDeviceService(DeviceService deviceService) throws Exception;

}
