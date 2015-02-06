package br.com.dextra.estagio2015.atv12;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementamos a classe sogra com id e nome (informações básicas para usar no HashSet)
 * Alteramos > 10 para CAPACIDADE, no if do viaja < refactor
 * @author laura.boscolo
 *
 */

public class Kombi {

	public Set<Sogra> sogras = new HashSet<Sogra>();
	public static int CAPACIDADE = 10;

	public void add(Sogra sogra) {
		if (sogras.size() >= CAPACIDADE) {
			throw new RuntimeException("Opa! Kombi lotada");
		} else {
			sogras.add(sogra);
		}
	}

	public void viaja() {
		if (sogras.size() > CAPACIDADE) {
			System.out.println("Tem mais de 10 Sogras nesta Kombi");
		}
	}

}
