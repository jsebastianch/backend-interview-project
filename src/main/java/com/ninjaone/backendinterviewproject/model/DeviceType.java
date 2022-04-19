package com.ninjaone.backendinterviewproject.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_type")
public class DeviceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private BigDecimal cost;
	
	

	/**
	 * Default constructor
	 */
	public DeviceType() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public DeviceType(Integer id, String name, BigDecimal cost) {
		this();
		this.id = id;
		this.name = name;
		this.cost = cost;
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
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
}
