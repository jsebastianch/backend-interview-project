/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.ninjaone.backendinterviewproject.enumeration.DeviceType;

/**
 * @author sebas
 *
 */
@Entity
public class Device {
	
	@Id
	private Integer id;
	
	private String systemName;
	
	@Enumerated(EnumType.STRING)
	private DeviceType type;

	/**
	 * Creates an instance of Device.
	 * @param id device Id
	 * @param systemName the system name
	 * @param type the type of the device
	 */
	public Device(Integer id, String systemName, DeviceType type) {
		super();
		this.id = id;
		this.systemName = systemName;
		this.type = type;
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
	 * Obtains the value for the field systemName.
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * Sets the value to the field systemName.
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * Obtains the value for the field type.
	 * @return the type
	 */
	public DeviceType getType() {
		return type;
	}

	/**
	 * Sets the value to the field type.
	 * @param type the type to set
	 */
	public void setType(DeviceType type) {
		this.type = type;
	}
	
}
