/**
 * 
 */
package com.ninjaone.backendinterviewproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.CustomerDeviceServiceRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.CustomerDeviceService;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.CustomerDeviceServiceService;

/**
 * @author Sebastian
 *
 */
@Service
public class CustomerDeviceServiceServiceImpl extends CRUDImpl<CustomerDeviceService, Integer>
		implements CustomerDeviceServiceService {
	
	@Autowired
	private CustomerDeviceServiceRepository repo;

	@Override
	protected IGenericRepo<CustomerDeviceService, Integer> getRepo() {
		return this.repo;
	}
	
	@Override
	public List<CustomerDeviceService> findByCustomer(Customer customer){
		return this.repo.findByCustomer(customer);
	}

	@Override
	public List<Device> findDistinctDeviceByCustomer(Customer customer) {
		return this.repo.findDistinctDeviceByCustomer(customer);
	}

}
