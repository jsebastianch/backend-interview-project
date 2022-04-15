/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author sebas
 *
 */
@Entity
@IdClass(DeviceTypeServiceCostPK.class)
public class DeviceTypeServiceCost {

	@Id
	private DeviceType deviceType;

	@Id
	private DeviceService deviceService;
	
	private BigDecimal cost;

	/**
	 * Obtains the value for the field deviceType.
	 * @return the deviceType
	 */
	public DeviceType getDeviceType() {
		return deviceType;
	}

	/**
	 * Sets the value to the field deviceType.
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * Obtains the value for the field deviceService.
	 * @return the deviceService
	 */
	public DeviceService getDeviceService() {
		return deviceService;
	}

	/**
	 * Sets the value to the field deviceService.
	 * @param deviceService the deviceService to set
	 */
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	/**
	 * Obtains the value for the field cost.
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * Sets the value to the field cost.
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
