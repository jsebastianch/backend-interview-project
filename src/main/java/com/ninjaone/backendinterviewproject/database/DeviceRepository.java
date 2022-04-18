/**
 * 
 */
package com.ninjaone.backendinterviewproject.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.Device;

/**
 * @author sebas
 *
 */
@Repository
public interface DeviceRepository extends IGenericRepo<Device, Integer> {
	
	public List<Device> findBySystemNameIgnoreCase(String systemNameIgnoreCase);

}
