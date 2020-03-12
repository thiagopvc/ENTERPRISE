package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.CidadeDAO;
import br.com.fiap.jpa.entity.Cidade;

public class CidadeDAOImpl 
					extends GenericDAOImpl<Cidade, Integer>
											implements CidadeDAO {

	public CidadeDAOImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public void cadastrar(Cidade entity) {
		super.cadastrar(entity);
	}

}