/**
 * 
 */
package com.ninjaone.backendinterviewproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninjaone.backendinterviewproject.dto.CustomerCostDetailDTO;
import com.ninjaone.backendinterviewproject.service.CustomerService;

/**
 * @author Sebastian
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/services-cost/{id}")
	public ResponseEntity<CustomerCostDetailDTO> getCustomerTotalCostOfServices(@PathVariable("id") Integer id)
			throws Exception {
		return new ResponseEntity<CustomerCostDetailDTO>(this.customerService.calculateCustomerMonthlyCost(id),
				HttpStatus.OK);
	}

}
