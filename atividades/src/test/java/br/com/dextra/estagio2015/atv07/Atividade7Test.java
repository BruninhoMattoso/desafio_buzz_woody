package br.com.dextra.estagio2015.atv07;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dextra.estagio2015.atv07.Atividade7;
import br.com.dextra.estagio2015.atv07.Comparator;
import br.com.dextra.estagio2015.atv07.ProdutoServiceImpl;
import br.com.dextra.estagio2015.comum.Produto;

public class Atividade7Test {
	
	//Refatorar e corrigir o metodo de verifica��o de datas, sem mexer no teste
	@Test
	public void verificaData(){
		Atividade7 calendario = new Atividade7();
		Assert.assertTrue(calendario.verificaData(1l, 1l, 1l));
	}
	
	//Refatorar e corrigir o metodo de compara��o de strings, sem mexer no teste
	@Test
	public void verificaString(){
		Comparator comparator = new Comparator();
		Assert.assertTrue(comparator.comparaStrings("Teste", "tesTe","tEste"));
	}
	
	//Corrigir o metodo de recupera��o de produtos, sem mexer no teste
	@Test
	public void testeProdutos() {
		ProdutoServiceImpl service = new ProdutoServiceImpl();
		service.criaProdutos();
		List<Produto> produtos = service.getProdutos();
		Assert.assertEquals(produtos.get(0).getNome(), "Caixa de Som");
		Assert.assertEquals(produtos.get(0).getComprimento(), 1);
		Assert.assertFalse(produtos.get(0).getPromocao());
		
		
	}
	
	
}
