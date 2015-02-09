package br.com.dextra.estagio2015.atv16;

import br.com.dextra.estagio2015.atv16.tv.Televisao;

/**
 * Refatoramos o código do método clickon, pois estava com:
 * Verificações desnecessárias, códigos "a mais"
 * Alteramos também o teste, de assertCanal, pois estava fazendo a comparação de String e "0" + getCanal(),
 * sem necessidade; 
 * @author laura.boscolo
 *
 */

public class ControleRemoto {

	private Televisao tv;
	private String display = "";

	public ControleRemoto(Televisao tv) {
		this.tv = tv;
	}

	public ControleRemoto setDisplay(String display) {
		this.display = display;
		return this;
	}

	public String getDisplay() {
		return display;
	}

	public void clickon(String botao) {
		if (NumberUtils.isNumber(botao)) {
			// Se o primeiro caracter é zero
			tv.setCanal(NumberUtils.asInt(botao));
			this.display = botao;
		} else {
			if (botao.contains("volume")) {
				if (botao.equalsIgnoreCase("abaixar volume")) {
					this.display = String.valueOf(tv.abaixarVolume()
							.getVolume());
				} else {
					this.display = String.valueOf(tv.aumentarVolume()
							.getVolume());
				}
			} else if (botao.contains("canal")) {
				if (botao.equalsIgnoreCase("canal anterior")) {
					this.display = String
							.valueOf(tv.canalAnterior().getCanal());
				} else {
					this.display = String.valueOf(tv.proximoCanal().getCanal());
				}
			} else if (botao.equals("liga")) {
				tv.setLigada(true);
			} else if (botao.equals("desliga")) {
				tv.setLigada(false);
			}
		}
	}
}