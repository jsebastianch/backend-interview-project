/**
 * 
 */
package com.ninjaone.backendinterviewproject.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.CustomerDeviceService;
import com.ninjaone.backendinterviewproject.model.Device;

/**
 * @author Sebastian
 *
 */
@Repository
public interface CustomerDeviceServiceRepository extends IGenericRepo<CustomerDeviceService, Integer> {
	
	public List<CustomerDeviceService> findByCustomer(Customer customer);
	
	@Query("select distinct cds.device FROM CustomerDeviceService cds WHERE cds.customer = ?1")
	List<Device> findDistinctDeviceByCustomer(Customer customer);

}
