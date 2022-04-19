/**
 * 
 */
package com.ninjaone.backendinterviewproject.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Sebastian
 *
 */
@Data
public class CustomerDeviceServiceDTO {

	private String serviceName;
	private BigDecimal serviceCost;
	
	
	/**
	 * Creates instance of CustomerDeviceServiceDTO.
	 * @param serviceName the service name
	 * @param serviceCost the cost
	 */
	public CustomerDeviceServiceDTO(String serviceName, BigDecimal serviceCost) {
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
	}
	
	

}
