package br.com.dextra.estagio2015.atv13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.JPA_DB_Utils;

public class Atividade13Test {

	
	
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
	@BeforeClass
	public static void setUp() throws Exception {
		JPA_DB_Utils.start();
	}
	
	@Test
	public void testInserirVenda() {
		VendaService service = new VendaService();
		
		Venda venda = new Venda();
		venda.add(new ItemVenda(10.0));
		venda.add(new ItemVenda(20.0));
		venda.add(new ItemVenda(30.0));
		service.inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		service.inserirVenda(venda);
		
		venda = new Venda();
		venda.add(new ItemVenda(100.0));
		venda.add(new ItemVenda(200.0));
		service.inserirVenda(venda);
		
		EntityManager em = JPAUtils.getEM();

		ArrayList<Venda> vendas = (ArrayList<Venda>) em.createQuery("FROM Venda").getResultList();
		for(int i = 0; i < 3; i++){
			assertEquals(new Long(i),vendas.get(i).getId());
		}
		assertEquals(3, vendas.size());
	
	}
}
