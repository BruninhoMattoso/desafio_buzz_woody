package br.com.dextra.estagio2015.atv13;

import br.com.dextra.estagio2015.comum.JPAUtils;

public class VendaService {

	public void inserirVenda(Venda venda) {
		try {
			JPAUtils.merge(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
