package br.com.dextra.estagio2015.atv02;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.dextra.estagio2015.atv02.Filho;

public class Atividade2Test {

	@Test
	public void teste1() {
		Filho f = new Filho("FilhoTeste");

		assertNotNull(f.abstrado());
	}

}
