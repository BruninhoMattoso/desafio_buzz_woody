package br.com.dextra.estagio2015.atv04;

import java.util.List;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dextra.estagio2015.atv04.CaixaEletronico;
import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;
import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.JPA_DB_Utils;

public class Atividade4Test {

	@BeforeClass
	public static void setUp() throws Exception {
		JPA_DB_Utils.start();
	}

	@Test
	public void testAdicionaContaParaCliente() {
		/*Cliente cliente = criaClienteTeste();
		Conta conta = new Conta(1000);
		
		CaixaEletronico.adicionaContaParaCliente(cliente, conta);
		
		EntityManager em = JPAUtils.getEM();
		Cliente clienteTeste = em.find(Cliente.class, cliente.getId());
		
		Assert.assertEquals(1, clienteTeste.getContas().size());*/
	}

	@Test 
	public void testListaContasDeCliente() {
		Cliente cliente = criaClienteTeste();
		
		Conta conta = new Conta(1000);
		//Conta conta2 = new Conta(2500);
		
		CaixaEletronico.adicionaContaParaCliente(cliente, conta);
		//CaixaEletronico.adicionaContaParaCliente(cliente, conta2);

		List<Conta> contasDeCliente = CaixaEletronico.listaContasDeCliente(cliente.getId());
		
		System.out.println("Contas");
		for (Conta c : contasDeCliente){
			System.out.println("Conta"+c.getId()+": "+c.getSaldo());
		}
		
		Assert.assertEquals(2, contasDeCliente.size());
	}
	
	@Test
	public void testCriarCliente(){
		Cliente c = new Cliente("Lura");
		JPAUtils.insert(c);
		
	}
	
	private Cliente criaClienteTeste() {
		Cliente c = new Cliente("Jeffinho PehFofo");
		JPAUtils.insert(c);
		return c;
	}
	
	
}
