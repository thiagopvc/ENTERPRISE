package com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.MoristaDAO;
import com.fiap.jpa.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MoristaDAO {

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

}
