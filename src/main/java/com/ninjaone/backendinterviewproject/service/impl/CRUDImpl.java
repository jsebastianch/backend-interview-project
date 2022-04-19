package com.ninjaone.backendinterviewproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.service.ICRUD;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T insert(T t) throws Exception {
		try {
			return getRepo().save(t);
		} catch (DataIntegrityViolationException e) {
			String errorMessage = e.getCause().getCause().getMessage();
			String detailMessage = errorMessage.indexOf("Detail: ") >= 0
					? errorMessage.substring(errorMessage.indexOf("Detail: ") + 8)
					: "";
			throw new Exception("Error de llave duplicada: " + detailMessage);
		}

	}

	@Override
	public T update(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		List<T> result = new ArrayList<T>();
		getRepo().findAll().forEach(result::add);
		return result;
	}

	@Override
	public T findById(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void delete(ID id) throws Exception {
		try {
			getRepo().deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error(e.getCause().getMessage());
			log.error(e.getMessage());
			throw new DataIntegrityViolationException("Can't delete, resource is in use");
		} catch (EmptyResultDataAccessException e) {
			log.error(e.getMessage());
			throw new EmptyResultDataAccessException("Can't delete, resource is not present.",e.getExpectedSize());
		}
	}

}