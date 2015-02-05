package br.com.dextra.estagio2015.atv13;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.dextra.estagio2015.comum.JPAUtils;

public class Atividade13 {

	/**
	 * O cliente (andrei@dextra-sw.com) mandou o seguinte email (aqui sem acentos porque eh codigo Java!):
	 * 
	 * "
	 * Pessoal,
	 * 
	 * O sistema esta bom, mas gostaria de fazer um pedido. Gostaria que os IDs das vendas fossem sequenciais. 
	 * Eles pulam alguns numeros em um ordem que eu nao entendo direito.
	 * 
	 * Fico no aguardo,
	 * 
	 * Obrigado.
	 * 
	 * "
	 * 
	 * ps: qualquer duvida entre em contato por email!
	 * 
	 */
	@Test
	public void testInserirVenda() {
		Venda venda = new Venda();
		venda.add(new ItemVenda(10.0));
		venda.add(new ItemVenda(20.0));
		venda.add(new ItemVenda(30.0));
		new VendaService().inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		new VendaService().inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		new VendaService().inserirVenda(venda);
		
		EntityManager em = JPAUtils.getEM();
		assertEquals(3, em.createQuery("FROM Venda").getResultList().size());
	}
}
