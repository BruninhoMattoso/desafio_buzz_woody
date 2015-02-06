package br.com.dextra.estagio2015.atv10;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.estagio2015.atv10.CintoDoElvis;

public class CintoDoElvisTest {

	@Test
	public void qualOTamanhoDoCintoDoElvisHoje() {
		int tamanhoPrevisto = Calendar.getInstance().get(Calendar.YEAR) - 1930;
		CintoDoElvis cintoDoElvis = new CintoDoElvis();
		
		Assert.assertEquals(tamanhoPrevisto, cintoDoElvis.getTamanhoDoCinto());
	}
}
