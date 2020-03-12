package com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.CorridaDAO;
import com.fiap.jpa.entity.Corrida;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

}
