/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.dto.CustomerCostDetailDTO;
import com.ninjaone.backendinterviewproject.model.Customer;

/**
 * @author Sebastian
 *
 */
public interface CustomerService extends ICRUD<Customer, Integer> {
	/**
	 * Calculates the total monthly cost of the services depending on Services used by a customer devices.
	 * @param id customer id
	 * @return  the total monthly cost of the services
	 * @throws Exception 
	 */
	public CustomerCostDetailDTO calculateCustomerMonthlyCost(Integer id) throws Exception;
}
