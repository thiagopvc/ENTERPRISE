package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import java.lang.reflect.ParameterizedType;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	//Atributo que armazena o T.class da Entidade
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@Override
	public T ler(K key) {
		return em.find(clazz, key);
	}

	@Override
	public void deletar(K key) throws KeyNotFoundException {
		T entity = ler(key);
		if (entity == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException(e.getMessage());
		}
	}

}