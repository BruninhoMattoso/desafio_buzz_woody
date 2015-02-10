package br.com.dextra.estagio2015.atv16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.dextra.estagio2015.at16.teclas.Tecla;
import br.com.dextra.estagio2015.at16.teclas.Tecla01;
import br.com.dextra.estagio2015.at16.teclas.Tecla02;
import br.com.dextra.estagio2015.at16.teclas.Tecla03;
import br.com.dextra.estagio2015.at16.teclas.Tecla04;
import br.com.dextra.estagio2015.at16.teclas.Tecla05;
import br.com.dextra.estagio2015.at16.teclas.Tecla06;
import br.com.dextra.estagio2015.at16.teclas.Tecla07;
import br.com.dextra.estagio2015.at16.teclas.Tecla08;
import br.com.dextra.estagio2015.at16.teclas.Tecla09;
import br.com.dextra.estagio2015.at16.teclas.TeclaAumentarVolume;
import br.com.dextra.estagio2015.at16.teclas.TeclaCanalAnterior;
import br.com.dextra.estagio2015.at16.teclas.TeclaDiminuirVolume;
import br.com.dextra.estagio2015.at16.teclas.TeclaLigaDesliga;
import br.com.dextra.estagio2015.at16.teclas.TeclaProximoCanal;
import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class TesteControleRemoto {

	@Test 
	public void ligaDesliga() {
		Televisao tv = getTelevisao();
		ControleRemoto controle = new ControleRemoto(tv);
		TeclaLigaDesliga tld = new TeclaLigaDesliga();
		
		if (!tv.isLigada()){
			controle.clickon(tld);
		}

		assertTrue(tv.isLigada());
	}
	
	@Test public void teclasNumericas() {
		Televisao tv = getTelevisao();
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertEquals(0, tv.getCanal());
		
		assertCanal(tv, controle, new Tecla01(), 1);
		assertCanal(tv, controle, new Tecla02(), 2);
		assertCanal(tv, controle, new Tecla03(), 3);
		assertCanal(tv, controle, new Tecla04(), 4);
		assertCanal(tv, controle, new Tecla05(), 5);
		assertCanal(tv, controle, new Tecla06(), 6);
		assertCanal(tv, controle, new Tecla07(), 7);
		assertCanal(tv, controle, new Tecla08(), 8);
		assertCanal(tv, controle, new Tecla09(), 9);
	}
	
	@Test public void teclasVolume() {
		Televisao tv = getTelevisao();
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertEquals(5, tv.getVolume());
		
		assertVolume(tv, controle, new TeclaDiminuirVolume(), 4);
		assertVolume(tv, controle, new TeclaAumentarVolume(), 5);
	}
	
	@Test public void teclasMudancaCanais() {
		Televisao tv = getTelevisao();
		
		ControleRemoto controle = new ControleRemoto(tv);
		
		assertCanal(tv, controle, new Tecla07(), 7);
		assertCanal(tv, controle, new TeclaCanalAnterior(), 6);
		assertCanal(tv, controle, new TeclaProximoCanal(), 7);
		assertCanal(tv, controle, new TeclaProximoCanal(), 8);
	}
	
	private static void assertVolume(Televisao tv, ControleRemoto controle, Tecla tecla, int volumeEsperado) {
		controle.clickon(tecla);
		
		assertEquals(volumeEsperado, tv.getVolume());
		assertEquals("" + volumeEsperado, controle.getDisplay());
	}
	
	private void assertCanal(Televisao tv, ControleRemoto controle, Tecla tecla, Integer expected) {
		assertEquals("", controle.getDisplay());
		
		controle.clickon(tecla);
		
		assertEquals(expected.intValue(), tv.getCanal());
		assertEquals("0"+expected.toString(), controle.getDisplay());
		
		controle.setDisplay("");
	}

	private Televisao getTelevisao() { 
		return new Televisao(); 
	}

}
