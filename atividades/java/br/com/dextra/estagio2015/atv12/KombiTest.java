package br.com.dextra.estagio2015.atv12;

import org.junit.Test;

import br.com.dextra.estagio2015.atv12.Kombi;
import br.com.dextra.estagio2015.atv12.Sogra;

public class KombiTest {

	private Kombi kombi = new Kombi();

	@Test
	public void colocarSograNaKombi() {

		for (int i = 0; i < 20; i++) {
			kombi.add(new Sogra());
		}
		kombi.viaja();
	}

}
