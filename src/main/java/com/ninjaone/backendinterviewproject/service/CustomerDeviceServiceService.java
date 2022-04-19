/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import java.util.List;

import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.CustomerDeviceService;
import com.ninjaone.backendinterviewproject.model.Device;

/**
 * @author Sebastian
 *
 */
public interface CustomerDeviceServiceService extends ICRUD<CustomerDeviceService, Integer> {

	/**
	 * Finds all the services given a customer.
	 * @param customer the customer
	 * @return list of services.
	 */
	List<CustomerDeviceService> findByCustomer(Customer customer);
	
	/**
	 * Finds a list of devices given a customer.
	 * @param customer the customer
	 * @return list of devices.
	 */
	List<Device> findDistinctDeviceByCustomer(Customer customer);

}
