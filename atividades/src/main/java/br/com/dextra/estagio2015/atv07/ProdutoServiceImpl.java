package br.com.dextra.estagio2015.atv07;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dextra.estagio2015.comum.JPAUtils;
import br.com.dextra.estagio2015.comum.Produto;

public class ProdutoServiceImpl {

	public void criaProdutos() {
		Produto produto1 = new Produto("Caixa de Som", "Caixa de som potente", 320.9, 1.1, 1.2, 0.8, 1,
				TipoProduto.ELETRONICO, false);
		Produto produto2 = new Produto("Barbeador", "Barbeador economico", 110.9, 0.5, 0.3, 0.1, 0.1,
				TipoProduto.SAUDE, true);
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
		Query query = em.createQuery("SELECT p.nome, p.tamanho, p.promocao FROM Produto p where p.id NOT IN :id",
				Produto.class);
		query.setParameter(":id", null);
		return query.getResultList();
	}

}
