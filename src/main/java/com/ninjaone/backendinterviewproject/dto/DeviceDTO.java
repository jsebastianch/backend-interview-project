/**
 * 
 */
package com.ninjaone.backendinterviewproject.dto;

/**
 * @author sebas
 *
 */
public class DeviceDTO {

	private Integer id;
	private String name;
	private Integer deviceTypeId;
	
	/**
	 * Default Constructor.
	 */
	public DeviceDTO() {
		// TODO Auto-generated constructor stub
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
	 * Obtains the value for the field name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value to the field name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
