package br.com.dextra.estagio2015.atv03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Atividade3Test {

	@Test
	public void criaBaralhoTest() {
		int[] valores = {1,2,3,4,5,6,7,8,9,10};
		char[] naipes = {'B'};
		Baralho b = new Baralho(valores,naipes);
		assertEquals(10,b.getQuantasCartas());
		Carta ultima = b.getCarta();
		Carta comp = new Carta(10,'B');
		assertEquals(comp.toString(),ultima.toString());
		ultima = b.getCarta();
		comp = new Carta(9,'B');
		assertEquals(comp.toString(),ultima.toString());
	}
	
	@Test
	public void jogadorTest(){
		Jogador j = new Jogador();
		j.pegarCarta(new Carta(10));
		assertEquals(10,j.getPontos());
		j.pegarCarta(new Carta(11));
		assertEquals(21,j.getPontos());
		assertFalse(j.perdeu());
		j.pegarCarta(new Carta(1));
		assertTrue(j.perdeu());
	}
	
	@Test
	public void blackJackTest(){
		BlackJack j = new BlackJack();
		assertEquals("O jogo ainda nao acabou", j.resultado());
		assertEquals(0,j.getVez());
		j.passaVez();
		assertEquals(1,j.getVez());
		j.passaVez();
		assertEquals("Empatou", j.resultado());
	}
	
	

}
