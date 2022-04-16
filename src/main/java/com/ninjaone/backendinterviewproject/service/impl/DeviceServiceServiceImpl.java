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
		List<DeviceService> services = this.repo.findByNameIgnoreCase(deviceService.getName());
		log.info("ESTA AQUI CONCHA");
		if (services != null && Boolean.FALSE.equals(services.isEmpty())) {
			throw new Exception("Device already exists");
		}
		return this.insert(deviceService);
	}

}
