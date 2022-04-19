/**
 * 
 */
package com.ninjaone.backendinterviewproject.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

/**
 * @author Sebastian
 *
 */
@Data
public class CustomerCostDetailDTO {
	
	private Integer customerId;
	private String customerName;
	private BigDecimal totalCost;
	private List<CustomerDeviceDTO> devices;

}
