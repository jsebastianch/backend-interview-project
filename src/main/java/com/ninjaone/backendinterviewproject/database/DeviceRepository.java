/**
 * 
 */
package com.ninjaone.backendinterviewproject.database;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.Device;

/**
 * @author sebas
 *
 */
@Repository
public interface DeviceRepository extends IGenericRepo<Device, Integer> {

}
