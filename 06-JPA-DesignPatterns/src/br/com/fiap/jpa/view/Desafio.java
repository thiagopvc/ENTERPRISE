package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Pais;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Desafio {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
	
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciando uma classe anonima, filha da GenericDAOImpl
		GenericDAO<Pais, Integer> dao = 
							new GenericDAOImpl<Pais, Integer>(em){}; 
		
		Pais pais = new Pais();
		pais.setNome("Uzbequistao");
		
		try {
			dao.cadastrar(pais);
			dao.commit();
			System.out.println("Pais cadastrado");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar");
		}
		
		
		
		em.close();
		fabrica.close();
	}
	
}
