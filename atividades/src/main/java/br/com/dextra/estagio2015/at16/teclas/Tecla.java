package br.com.dextra.estagio2015.at16.teclas;

import br.com.dextra.estagio2015.atv16.ControleRemoto;
import br.com.dextra.estagio2015.atv16.tv.Televisao;

public abstract class Tecla {
	protected Televisao tv;
	protected ControleRemoto controle;
	
	public abstract void constructor(Televisao tv, ControleRemoto controle);
	public abstract void click();
}

