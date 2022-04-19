/**
 * 
 */
package com.ninjaone.backendinterviewproject.database;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.Customer;

/**
 * @author Sebastian
 *
 */
@Repository
public interface CustomerRepository extends IGenericRepo<Customer, Integer> {

}
