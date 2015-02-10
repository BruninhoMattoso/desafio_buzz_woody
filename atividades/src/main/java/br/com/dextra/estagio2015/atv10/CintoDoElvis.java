package br.com.dextra.estagio2015.atv10;

import java.util.Calendar;

/**
 * Alteramos a forma como o programa inicializando a instancia.
 * Instancia como constante para ter apenas uma instancia rodando, sempre?
 * 
 */

/**
 * Dizem que o rei do Rock'n'Roll, após a fama, engordava um número do cinto a
 * cada ano, e que este número coincidia com a sua idade. Ele nasceu em 1930.
 * Este programa serve para saber qual seria o tamanho do cinto dele se ele
 * estivesse vivo este ano.
 */
public class CintoDoElvis {
	public static final CintoDoElvis INSTANCIA = new CintoDoElvis();
	private final int tamanhoDoCinto;
	private int ano_atual;

	public CintoDoElvis() {
		ano_atual = Calendar.getInstance().get(Calendar.YEAR);
		tamanhoDoCinto = ano_atual - 1930;
	}

	public int getTamanhoDoCinto() {
		return tamanhoDoCinto;
	}
}
