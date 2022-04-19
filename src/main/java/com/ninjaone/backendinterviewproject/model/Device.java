/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sebas
 *
 */
@Entity
@Table(name = "device")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "system_name", nullable = false)
	private String systemName;
	
	@ManyToOne
	@JoinColumn(name = "device_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_device_to_device_type"))
	private DeviceType type;

	/**
	 * Default contructor.
	 */
	public Device() {
		super();
	}

	/**
	 * Creates an instance of Device.
	 * @param id device Id
	 * @param systemName the system name
	 * @param type the type of the device
	 */
	public Device(Integer id, String systemName, DeviceType type) {
		this();
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
