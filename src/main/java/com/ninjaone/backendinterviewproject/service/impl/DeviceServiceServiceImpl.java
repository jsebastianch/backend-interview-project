/**
 * 
 */
package com.ninjaone.backendinterviewproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.DeviceServiceRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceServiceService;

import lombok.extern.log4j.Log4j2;

/**
 * @author sebas
 *
 */
@Service
@Log4j2
public class DeviceServiceServiceImpl extends CRUDImpl<DeviceService, Integer> implements DeviceServiceService {

	@Autowired
	private DeviceServiceRepository repo;

	@Override
	protected IGenericRepo<DeviceService, Integer> getRepo() {
		return this.repo;
	}

	@Override
	public DeviceService insertDeviceService(DeviceService deviceService) throws Exception {
		log.info("Inserting device");
		this.isDuplicateDeviceService(deviceService);
		return this.insert(deviceService);
	}
	
	@Override
	public DeviceService update(DeviceService deviceService) throws Exception {
		log.info("Inserting device");
		this.isDuplicateDeviceService(deviceService);
		return super.update(deviceService);
	} 
	
	/**
	 * Checks if a service has been already created.
	 * @param deviceService the service to check
	 * @throws Exception if device is present.
	 */
	private void isDuplicateDeviceService(DeviceService deviceService) throws Exception {
		List<DeviceService> services = this.repo.findByNameIgnoreCase(deviceService.getName());
		Boolean updating = deviceService.getId() != null;
		if (services != null && Boolean.FALSE.equals(services.isEmpty()) && Boolean.FALSE.equals(updating)) {
			log.info("Service name already exists.");
			throw new Exception("Service already exists when creating");
		} else if (services != null && Boolean.FALSE.equals(services.isEmpty())) {
			for (DeviceService ds : services) {
				if(deviceService.getId().compareTo(ds.getId()) != 0) {
					log.info("Service name already exists when updating.");
					throw new Exception("Service already exists");
				}
			}
		}
	}

}
