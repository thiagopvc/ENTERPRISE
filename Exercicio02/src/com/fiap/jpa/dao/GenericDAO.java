package com.fiap.jpa.dao;

import com.fiap.jpa.exception.CommitException;
import com.fiap.jpa.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {
void cadastrar(T entity);
	
	void atualizar(T entity);
	
	T ler(K key);
	
	void deletar(K key) throws KeyNotFoundException;
	
	void commit() throws CommitException;
}
