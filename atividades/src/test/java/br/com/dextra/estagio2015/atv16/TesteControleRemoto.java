package br.com.dextra.estagio2015.atv16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.dextra.estagio2015.atv16.ControleRemoto;
import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class TesteControleRemoto {

	@Test 
	public void ligaDesliga() {
		Televisao tv = getTelevisao();
		
//		assertFalse(tv.isLigada());
		if (!tv.isLigada()){
			new ControleRemoto(tv).clickon("desliga");
		}

		assertTrue(!tv.isLigada());
	}
	
	@Test public void teclasNumericas() {
		Televisao tv = getTelevisao();
		assertEquals(0, tv.getCanal());
		
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertCanal(tv, controle, "01");
		assertCanal(tv, controle, "00");
		assertCanal(tv, controle, "02");
		assertCanal(tv, controle, "03");
		assertCanal(tv, controle, "04");
		assertCanal(tv, controle, "05");
		assertCanal(tv, controle, "06");
		assertCanal(tv, controle, "07");
		assertCanal(tv, controle, "08");
		assertCanal(tv, controle, "09");
	}
	
	@Test public void teclasVolume() {
		Televisao tv = getTelevisao();
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertEquals(5, tv.getVolume());
		assertVolume(tv, controle, "abaixar volume", 4);
		assertVolume(tv, controle, "aumentar volume", 5);
		assertVolume(tv, controle, "aumentar volume", 6);
	}
	
	@Test public void teclasMudancaCanais() {
		Televisao tv = getTelevisao();
		
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertCanal(tv, controle, "07");
		assertCanal(tv, controle, "canal anterior", 6);
		assertCanal(tv, controle, "canal proximo", 7);
		assertCanal(tv, controle, "canal proximo", 8);
	}
	

	private static void click(ControleRemoto controle, String tecla) {
		controle.clickon(tecla);
	}
	
	private static void assertVolume(Televisao tv, ControleRemoto controle, String tecla, int volumeEsperado) {
		click(controle, tecla);
		
		assertEquals(volumeEsperado, tv.getVolume());
		assertEquals("" + volumeEsperado, controle.getDisplay());
	}
	
	private void assertCanal(Televisao tv, ControleRemoto controle, String tecla, Integer expected) {
		assertEquals("", controle.getDisplay());
		
		click(controle, tecla);
		
		assertEquals(expected.intValue(), tv.getCanal());
		assertEquals(expected.toString(), controle.getDisplay());
		
		controle.setDisplay("");
	}

	private static void assertCanal(Televisao tv, ControleRemoto controle, String tecla) {
		assertEquals("", controle.getDisplay());
		
		click(controle, tecla);
		
		assertEquals(tecla, "0" + tv.getCanal());
		assertEquals(tecla, controle.getDisplay());
		
		controle.setDisplay("");
	}
	
	private Televisao getTelevisao() { 
		return new Televisao(); 
	}

}
