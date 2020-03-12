package com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.GenericDAO;
import com.fiap.jpa.exception.CommitException;
import com.fiap.jpa.exception.KeyNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	
	private EntityManager em;
	private Class<T> clazz;
	
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T ler(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(K key) throws KeyNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() throws CommitException {
		// TODO Auto-generated method stub
		
	}

}
