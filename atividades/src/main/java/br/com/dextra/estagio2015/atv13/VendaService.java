package br.com.dextra.estagio2015.atv13;

import br.com.dextra.estagio2015.comum.JPAUtils;

public class VendaService {

	void inserirVenda(Venda venda) {
		try {
			JPAUtils.insert(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
