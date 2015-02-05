package br.com.dextra.estagio2015.atv07;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.Produto;

public class ProdutoServiceImpl {
	
	public void criaProdutos() {
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();		
		produto1.setNome("Caixa de Som");
		produto2.setNome("Barbeador");
		produto1.setAltura(1.20);
		produto2.setAltura(0.3);
		produto1.setComprimento(1);
		produto2.setComprimento(0.1);
		produto1.setDescricao("Caixa de som potente");
		produto2.setDescricao("Barbeador economico");
		produto1.setLargura(0.8);
		produto2.setLargura(0.1);
		produto1.setPeso(1.1);
		produto2.setPeso(0.5);
		produto1.setPreco(320.9);
		produto2.setPreco(110.9);
		produto1.setPromocao(false);
		produto2.setPromocao(true);
		produto1.setTipoProduto(TipoProduto.ELETRONICO);
		produto2.setTipoProduto(TipoProduto.SAUDE);
		
		EntityManager em = null;
		try {
			em = JPAUtils.getEM();
			em.getTransaction().begin();
			em.merge(produto1);
			em.getTransaction().commit();
			em.merge(produto2);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}
	
	public List<Produto> getProdutos() {
		EntityManager em = JPAUtils.getEM();
		Query query = em.createQuery("SELECT p.nome, p.tamanho, p.promocao FROM Produto p where p.id NOT IN :id", Produto.class);
		query.setParameter(":id", null);
		return query.getResultList();
	}

}
