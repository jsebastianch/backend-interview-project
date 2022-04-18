/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sebas
 *
 */
@Entity
public class CustomerDeviceService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_cds_to_customer"))
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "device_id", nullable = false, foreignKey = @ForeignKey(name = "FK_cds_to_device"))
	private Device device;
	
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false, foreignKey = @ForeignKey(name = "FK_cds_to_service"))
	private DeviceService deviceService;

	/**
	 * Default constructor.
	 */
	public CustomerDeviceService() {
		super();
	}

	/**
	 * Obtains the value for the field id.
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value to the field id.
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtains the value for the field customer.
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the value to the field customer.
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Obtains the value for the field device.
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * Sets the value to the field device.
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
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

}
