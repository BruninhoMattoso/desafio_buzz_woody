package br.com.dextra.estagio2015.atv16;

import br.com.dextra.estagio2015.at16.teclas.Tecla;
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

	public void clickon(Tecla tecla) {
		tecla.constructor(tv, this);
		tecla.click();
	}
}