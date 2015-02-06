package br.com.dextra.estagio2015.atv04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.estagio2015.comum.Cliente;
import br.com.dextra.estagio2015.comum.Conta;
import br.com.dextra.estagio2015.comum.JPAUtils;

public class CaixaEletronico {

	public static List<Conta> listaContasDeCliente(Long idCliente) {
		EntityManager em = null;
		Cliente cliente = null;
		try {
			em = JPAUtils.getEM();
			Query query = em.createQuery("SELECT c FROM Cliente c JOIN FETCH c.contas WHERE c.id = (:id)");
			query.setParameter("id", idCliente);
			cliente = (Cliente) query.getSingleResult();
		} finally { 
			if (em != null)
				em.close();
		}
		
		return cliente.getContas();
	}

	public static Cliente adicionaContaParaCliente(Cliente cliente, Conta conta) {
		EntityManager em = null;
		Cliente c = null;
		try {
			em = JPAUtils.getEM();
			em.getTransaction().begin();
			cliente.addConta(conta);
			c = em.merge(cliente);
			em.getTransaction().commit();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			if (em != null) {
				em.close();
			}
		}
		
		return c;
	}
	
}