/**
 * 
 */
package com.ninjaone.backendinterviewproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;

import lombok.extern.log4j.Log4j2;

/**
 * @author sebas
 *
 */
@Log4j2
@Service
public class DeviceServiceImpl extends CRUDImpl<Device, Integer> implements DeviceService{

	@Autowired	
	private DeviceRepository repo;

	@Override
	protected IGenericRepo<Device, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Device insert(Device device) throws Exception {
		log.info("Inserting device");
		this.isDuplicateDevice(device);
		return super.insert(device);
	}
	
	@Override
	public Device update(Device device) throws Exception {
		log.info("Updating device");
		this.isDuplicateDevice(device);
		return super.update(device);
	} 
	
	/**
	 * Checks if a device has been already created.
	 * @param device the device to check
	 * @throws Exception if device is present.
	 */
	private void isDuplicateDevice(Device device) throws Exception {
		List<Device> devices = this.repo.findBySystemNameIgnoreCase(device.getSystemName());
		Boolean updating = device.getId() != null;
		if (devices != null && Boolean.FALSE.equals(devices.isEmpty()) && Boolean.FALSE.equals(updating)) {
			log.info("Device name already exists.");
			throw new Exception("Device already exists when creating");
		} else if (devices != null && Boolean.FALSE.equals(devices.isEmpty())) {
			for (Device ds : devices) {
				if(device.getId().compareTo(ds.getId()) != 0) {
					log.info("Device name already exists when updating.");
					throw new Exception("Device already exists");
				}
			}
		}
	}

}
