package com.ninjaone.backendinterviewproject.dto;

import java.math.BigDecimal;

public class DeviceTypeServiceCostDTO {
	
	private Integer deviceTypeId;
	private Integer serviceId;
	private BigDecimal cost;


	/**
	 * Default constructor. 
	 */
	public DeviceTypeServiceCostDTO() {
		super();
	}
	

	/**
	 * Creates an instance of this object.
	 * @param deviceTypeId the device type id
	 * @param serviceId the service id
	 * @param cost the cost of the service for this device type
	 */
	public DeviceTypeServiceCostDTO(Integer deviceTypeId, Integer serviceId, BigDecimal cost) {
		this();
		this.deviceTypeId = deviceTypeId;
		this.serviceId = serviceId;
		this.cost = cost;
	}


	/**
	 * Obtains the value for the field deviceTypeId.
	 * @return the deviceTypeId
	 */
	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}


	/**
	 * Sets the value to the field deviceTypeId.
	 * @param deviceTypeId the deviceTypeId to set
	 */
	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}


	/**
	 * Obtains the value for the field serviceId.
	 * @return the serviceId
	 */
	public Integer getServiceId() {
		return serviceId;
	}


	/**
	 * Sets the value to the field serviceId.
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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
