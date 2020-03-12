package com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.VeiculoDAO;
import com.fiap.jpa.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
