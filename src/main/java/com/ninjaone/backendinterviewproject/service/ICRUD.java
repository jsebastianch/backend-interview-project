package com.ninjaone.backendinterviewproject.service;

import java.util.List;

public interface ICRUD<T, ID> {

	T insert(T t) throws Exception;

	T update(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(ID id) throws Exception;

	void delete(ID id) throws Exception;
}
