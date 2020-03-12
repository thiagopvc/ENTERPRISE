package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Gerenciar a única instancia do EntityManagerFactory
public class EntityManagerFactorySingleton {

	//Declarar o atributo que tera uma única instancia
	private static EntityManagerFactory fabrica;
	
	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//Método que cria a única instancia
	public static EntityManagerFactory getInstance() {
		//Valida se já existe um objeto da fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}
