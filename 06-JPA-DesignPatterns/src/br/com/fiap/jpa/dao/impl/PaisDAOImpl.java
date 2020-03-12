package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.PaisDAO;
import br.com.fiap.jpa.entity.Pais;

public class PaisDAOImpl 
				extends GenericDAOImpl<Pais, Integer> 
										implements PaisDAO {

	public PaisDAOImpl(EntityManager em) {
		super(em);
	}
	

}