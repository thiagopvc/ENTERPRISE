package br.com.fiap.jpa.teste;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.CidadeDAO;
import br.com.fiap.jpa.dao.impl.CidadeDAOImpl;
import br.com.fiap.jpa.entity.Cidade;
import br.com.fiap.jpa.entity.Estado;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

class CidadeDAOTeste {

	private static CidadeDAO dao;
	private Cidade cidade;

	// Metodo que é chamado antes de todos os teste
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		dao = new CidadeDAOImpl(em);
	}

	@Test
	@BeforeEach // Metodo chamado antes de cada teste
	public void cadastrar() {
		cidade = new Cidade("sao paulo", Estado.SP);

		// Act
		try {
			dao.cadastrar(cidade);
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no commit");
		}
	}

	@Test
	@DisplayName("Teste de nome obrigatorio")
	void atualizacaoSemNomeTeste() {
		cidade.setNome(null);
		
		dao.atualizar(cidade);
		//Valida se deu erro ao realizar o commit, devido ao nome obrigatorio
		assertThrows(CommitException.class, () -> {dao.commit();});
	}

	@Test
	@DisplayName("Teste de remocao com codigo invalido")
	void remocaoFalhaTeste() {
		assertThrows(KeyNotFoundException.class, () -> {
			dao.deletar(0);
		});
	}

	@Test
	@DisplayName("Teste de remocao com sucesso")
	void remocaoSucessoTeste() {
		try {
			dao.deletar(cidade.getCodigo());
			dao.commit();
		} catch (KeyNotFoundException e) {
			fail("Falha no delete");
		} catch (CommitException e) {
			fail("Falha no commit");
		}

		Cidade busca = dao.ler(cidade.getCodigo());
		assertNull(busca);

	}

	@Test
	@DisplayName("Teste de atualizacao com sucesso")
	void atualizacaoSucessoTeste() {
		// Act
		cidade.setNome("Gramado");
		try {
			dao.atualizar(cidade);
			dao.commit();
		} catch (CommitException e) {
			fail("Falha no commit");
		}
		Cidade busca = dao.ler(cidade.getCodigo());
		assertEquals("Gramado", busca.getNome());
	}

	@Test
	void cadastroSucessoTest() {
		// Valida se o codigo foi gerado pela sequence
		assertNotEquals(0, cidade.getCodigo());
	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void pesquisaSucessoTeste() {

		Cidade busca = dao.ler(cidade.getCodigo());
		// Valida se o nome da cidade pesquisada
		assertEquals("sao paulo", busca.getNome());
	}
}
