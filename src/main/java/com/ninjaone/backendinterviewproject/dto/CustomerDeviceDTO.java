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
public class CustomerDeviceDTO {
	private Integer deviceId;
	private String deviceName;
	private String deviceType;
	private BigDecimal deviceCost;
	private List<CustomerDeviceServiceDTO> services;
	
	/**
	 * Creates an instance of CustomerDeviceDTO.
	 * @param deviceId the device id
	 * @param deviceName the device name
	 * @param deviceType the device type name
	 * @param deviceCost the device cost
	 * @param services device services
	 */
	public CustomerDeviceDTO(Integer deviceId, String deviceName, String deviceType, BigDecimal deviceCost,
			List<CustomerDeviceServiceDTO> services) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.deviceCost = deviceCost;
		this.services = services;
	}

	
}
