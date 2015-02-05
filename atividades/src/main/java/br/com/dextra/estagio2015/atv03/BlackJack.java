package br.com.dextra.estagio2015.atv03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Esse blackjack está inteiro na função main. Acreditamos que ele funciona. Mas
 * nosso cliente andou reclamando. Combinamos com ele e vamos adicionar testes
 * JUnit para esse jogo e tentar deixar o código mais orientado a objetos. Só
 * que também combinamos que o jogo não pode ficar sem funcionar. Tem que
 * funcionar durante a transformação de código estruturado para orientado a
 * objetos.
 * 
 */
public class BlackJack {

	private Baralho baralho;
	private Jogador jogador, computador;
	private int vez;// 0 = jogador, 1 = computador, 2 = fim

	public BlackJack() {
		int[] valores = { 2, 3, 4, 5, 6, 10, 10, 10, 11 };
		char[] naipes = { 'E', 'C', 'P', 'O' };
		baralho = new Baralho(valores, naipes);
		baralho.embaralhar();
		jogador = new Jogador();
		computador = new Jogador();
		vez = 0;
	}

	public void pegaCarta() {
		switch (vez) {
		case 0: {
			jogador.pegarCarta(baralho.getCarta());
			if (jogador.perdeu())
				vez = 2;
		}
			break;
		case 1: {
			computador.pegarCarta(baralho.getCarta());
			if (computador.getPontos() >= 20)
				vez++;
		}
			break;
		}
	}

	public int getVez() {
		return vez;
	}

	public boolean vezJogador() {
		return vez == 0;
	}

	public boolean vezComputador() {
		return vez == 1;
	}

	public boolean fimJogo() {
		return vez == 2;
	}

	public String resultado() {
		if (!fimJogo())
			return "O jogo ainda nao acabou";

		if (jogador.perdeu()) {
			return "Perdeu";
		}
		if (computador.perdeu() || jogador.getPontos() > computador.getPontos()) {
			return "Ganhou";
		}
		if (computador.getPontos() > jogador.getPontos())
			return "Perdeu";
		return "Empatou";
	}

	public void passaVez() {
		vez++;
	}

	public static void main(String[] args) {

		BlackJack jogo = new BlackJack();

		while (jogo.vezJogador()) {
			System.out.println("Pega carta (c) ou para (p) ?");
			Scanner entrada = new Scanner(System.in);
			String comando = entrada.nextLine();
			if (comando.equals("c")) {
				jogo.pegaCarta();
			}
			if (comando.equals("p")) {
				jogo.passaVez();
			}
		}
		while (!jogo.fimJogo()) {
			jogo.pegaCarta();
		}
		System.out.println(jogo.resultado());
	}
	/*
	 * boolean parou = false; boolean jogadorGanhou = false; boolean
	 * computadorGanhou = false; int pontosJogador = 0; int pontosComputador =
	 * 0; List maoDoJogador = new ArrayList(); List maoDoComputador = new
	 * ArrayList();
	 * 
	 * System.out.println("Pega carta (c) ou para (p) ?"); Scanner entrada = new
	 * Scanner(System.in); String comando = entrada.nextLine(); if
	 * (comando.equals("p")) parou = true;
	 * 
	 * while (!parou) { maoDoJogador.add(pegaCarta()); escreveMao(maoDoJogador);
	 * pontosJogador = calculaPontuacao(maoDoJogador);
	 * System.out.println("Pontuacao " + pontosJogador);
	 * 
	 * if (pontosJogador > 21) { System.out.println("Perdeu"); computadorGanhou
	 * = true; parou = true; break; } else if (pontosJogador == 21) {
	 * System.out.println("Ganhou"); jogadorGanhou = true; parou = true; break;
	 * }
	 * 
	 * System.out.println("Pega carta ou para?"); comando = entrada.nextLine();
	 * if (comando.equals("p")) parou = true; }
	 * 
	 * if (!jogadorGanhou && !computadorGanhou) {
	 * System.out.println("COMPUTADOR JOGA"); while (pontosComputador < 20) { //
	 * computador nunca faz 21, mas isso // nao eh problema
	 * maoDoComputador.add(pegaCarta()); escreveMao(maoDoComputador);
	 * pontosComputador = calculaPontuacao(maoDoComputador);
	 * System.out.println("Pontuacao " + pontosComputador); }
	 * 
	 * System.out.println("---------------------------------");
	 * System.out.println("Pontuacao Jogador " + pontosJogador);
	 * System.out.println("Pontuacao Computador " + pontosComputador); if
	 * (pontosComputador == 21) { System.out.println("computador ganhou"); }
	 * else if (pontosComputador > 21 && pontosJogador < 21) {
	 * System.out.println("jogador ganhou"); } else if (pontosComputador < 21 &&
	 * (pontosComputador > pontosJogador)) {
	 * System.out.println("computador ganhou"); } else if (pontosComputador ==
	 * pontosJogador) { System.out.println("Empate"); } } }
	 * 
	 * private static void escreveMao(List maoDoJogador) { String mao =
	 * "Cartas: "; for (Iterator it = maoDoJogador.iterator(); it.hasNext();) {
	 * Integer carta = (Integer) it.next(); mao += carta + ","; }
	 * 
	 * System.out.println(mao); }
	 * 
	 * private static void inicializaBaralho() {
	 * 
	 * // no 21, o naipe nao importa // cada linha eh um naipe, o 11 é o AS, pq
	 * essa é a pontuacao dele no // jogo baralho = Arrays.asList(2, 3, 4, 5, 6,
	 * 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10, 11, 2, 3, 4, 5, 6, 10, 10, 10,
	 * 11, 2, 3, 4, 5, 6, 10, 10, 10, 11);
	 * 
	 * Collections.shuffle(baralho); }
	 * 
	 * private static int calculaPontuacao(List maoDoJogador) {
	 * 
	 * int pontuacao = 0; for (Iterator it = maoDoJogador.iterator();
	 * it.hasNext();) { Integer carta = (Integer) it.next(); pontuacao += carta;
	 * }
	 * 
	 * return pontuacao; }
	 * 
	 * private static int pegaCarta() { Collections.shuffle(baralho); return
	 * (Integer) baralho.get(0); }
	 */
}
