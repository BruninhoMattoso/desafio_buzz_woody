package br.com.dextra.estagio2015.atv04;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;
import br.com.dextra.estagio2015.comum.JPAUtils;

public class CaixaEletronico {

	public static List<Conta> listaContasDeCliente(Long idCliente) {
		EntityManager em = null;
		Cliente cliente = null;
		
		System.out.println("id: "+idCliente);
		try {
			em = JPAUtils.getEM();
			cliente = em.find(Cliente.class, idCliente);
		} catch (Exception e){
			e.printStackTrace();
		} finally { 
			if (em != null)
				em.close();
		}
		
		System.out.println("Conta 0"+cliente.getContas().get(0).getSaldo()); // erros
		
		for (Conta c : cliente.getContas()){
			System.out.println("Cliente"+idCliente+": ");
			System.out.println("Conta"+c.getId()+": "+c.getSaldo());
		}
		
		return cliente.getContas();
	}

	public static void adicionaContaParaCliente(Cliente cliente, Conta conta) {
		EntityManager em = null;
		
		try {
			em = JPAUtils.getEM();
			em.getTransaction().begin();
			
			if (conta.getId() == null){
				JPAUtils.insert(conta);
			}
			
			cliente.addConta(conta);
			em.merge(cliente);
			
			em.getTransaction().commit();
			
			System.out.println("Deu commit!"+cliente.getId());
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
}
