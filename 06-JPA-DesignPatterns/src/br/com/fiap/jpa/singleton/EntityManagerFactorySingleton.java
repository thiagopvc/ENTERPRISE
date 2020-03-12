package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Gerenciar a �nica instancia do EntityManagerFactory
public class EntityManagerFactorySingleton {

	//Declarar o atributo que tera uma �nica instancia
	private static EntityManagerFactory fabrica;
	
	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//M�todo que cria a �nica instancia
	public static EntityManagerFactory getInstance() {
		//Valida se j� existe um objeto da fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}
