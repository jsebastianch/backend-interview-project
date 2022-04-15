package com.ninjaone.backendinterviewproject.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T, ID> extends CrudRepository<T, ID>{

}
