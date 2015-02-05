package br.com.dextra.estagio2015.atv15;

import java.math.BigDecimal;

public class Atividade15 {

	public static BigDecimal pagamento(BigDecimal valor, BigDecimal pagamento) {
		return pagamento.subtract(valor);
	}

}
