/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sebas
 *
 */
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	/**
	 * Default constructor.
	 */
	public Customer() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public Customer(Integer id, String name) {
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

}
