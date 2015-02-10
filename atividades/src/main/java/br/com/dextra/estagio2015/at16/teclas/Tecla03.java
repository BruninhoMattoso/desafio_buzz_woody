package br.com.dextra.estagio2015.at16.teclas;

import br.com.dextra.estagio2015.atv16.ControleRemoto;
import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class Tecla03 extends Tecla {
	public static final int CANAL = 3;
	

	@Override
	public void constructor(Televisao tv, ControleRemoto controle) {
		this.tv = tv;
		this.controle = controle;
	}

	@Override
	public void click() {
		tv.setCanal(CANAL);
		controle.setDisplay("0"+CANAL);
	}
	
	
}
