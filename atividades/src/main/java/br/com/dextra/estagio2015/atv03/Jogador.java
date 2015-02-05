package br.com.dextra.estagio2015.atv03;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private List<Carta> mao;
	
	
	public Jogador(){
		this.mao = new ArrayList<Carta>();
	}
	
	public void pegarCarta(Carta c){
		mao.add(c);
	}
	
	public boolean removerCarta(Carta qual){
		return mao.remove(qual);
	}
	
	public boolean perdeu(){
		return this.getPontos() > 21;
	}
	
	public int getPontos(){
		int pontos = 0;
		for(Carta c : mao){
			pontos += c.getValor();
		}
		return pontos;
	}
	
	public int getQuantasCartas(){
		return mao.size(); 	
	}

	public List<Carta> getMao() {
		return mao;
	}

	public void setMao(List<Carta> mao) {
		this.mao = mao;
	}
	
	
}
