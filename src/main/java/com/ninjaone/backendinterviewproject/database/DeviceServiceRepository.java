/**
 * 
 */
package com.ninjaone.backendinterviewproject.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.DeviceService;

/**
 * @author sebas
 *
 */
@Repository
public interface DeviceServiceRepository extends IGenericRepo<DeviceService, Integer> {
	List<DeviceService> findByNameIgnoreCase(String name);
}
