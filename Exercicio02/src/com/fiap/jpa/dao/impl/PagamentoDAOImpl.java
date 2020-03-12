package com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.fiap.jpa.dao.PagamentoDAO;
import com.fiap.jpa.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
