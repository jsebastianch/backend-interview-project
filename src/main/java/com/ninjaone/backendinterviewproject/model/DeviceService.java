/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sebas
 *
 */
@Entity
@Table(name = "device_service")
public class DeviceService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	

	/**
	 * Default constructor.
	 */
	public DeviceService() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public DeviceService(Integer id, String name) {
		this();
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return "DeviceService [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceService other = (DeviceService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
