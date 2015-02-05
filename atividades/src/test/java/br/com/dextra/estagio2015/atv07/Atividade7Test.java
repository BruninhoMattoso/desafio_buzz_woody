package br.com.dextra.estagio2015.atv07;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dextra.estagio2015.comum.JPA_DB_Utils;
import br.com.dextra.estagio2015.comum.Produto;

public class Atividade7Test {

	@BeforeClass
	public static void setUp() throws Exception {
		JPA_DB_Utils.start();
	}

	// Refatorar e corrigir o metodo de verificacao de datas, sem mexer no teste
	@Test
	public void verificaData() {
		Atividade7 calendario = new Atividade7();
		assertTrue(calendario.verificaData(1l, 1l, 1l));
	}

	// Refatorar e corrigir o metodo de comparacao de strings, sem mexer no
	// teste
	@Test
	public void verificaString() {
		Comparator comparator = new Comparator();
		assertTrue(comparator.comparaStrings("Teste", "tesTe", "tEste"));
	}

	// Corrigir o metodo de recuperacao de produtos, sem mexer no teste
	@Test
	public void testeProdutos() {
		ProdutoServiceImpl service = new ProdutoServiceImpl();
		service.criaProdutos();
		List<Produto> produtos = service.getProdutos();
		assertEquals(produtos.get(0).getNome(), "Caixa de Som");
		assertEquals(produtos.get(0).getComprimento(), 1);
		assertFalse(produtos.get(0).getPromocao());
	}

}
