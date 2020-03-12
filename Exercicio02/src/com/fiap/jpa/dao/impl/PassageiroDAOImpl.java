package com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.PassageiroDAO;
import com.fiap.jpa.entity.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer> implements PassageiroDAO{

	public PassageiroDAOImpl(EntityManager em) {
		super(em);
	}

}
