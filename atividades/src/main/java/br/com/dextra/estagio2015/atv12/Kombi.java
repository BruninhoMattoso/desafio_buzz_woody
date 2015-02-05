package br.com.dextra.estagio2015.atv12;

import java.util.HashSet;
import java.util.Set;

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
		if (sogras.size() > 10) {
			System.out.println("Tem mais de 10 Sogras nesta Kombi");
		}
	}

}
