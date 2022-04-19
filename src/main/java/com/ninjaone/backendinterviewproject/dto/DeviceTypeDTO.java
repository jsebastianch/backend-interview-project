/**
 * 
 */
package com.ninjaone.backendinterviewproject.dto;

import java.math.BigDecimal;

/**
 * @author Sebastian
 *
 */
public class DeviceTypeDTO {

	private Integer id;
	private String name;
	private BigDecimal cost;

	/**
	 * 
	 */
	public DeviceTypeDTO() {
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
