package br.com.dextra.estagio2015.atv03;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Collections;

public class Baralho {

	private List<Carta> cartas;

	/**
	 * 
	 * @param valorDasCartas
	 *            Sequencia dos valores das cartas. Por exemplo:
	 *            {2,3,4,5,6,8,9,10}
	 * @param naipes
	 *            Sequencia de naipes presentes no baralho. Por exemplo: {'C',
	 *            'O', 'E', 'P'} -> Copas, Ouros, Espadas e Paus
	 */
	public Baralho(int[] valorDasCartas, char[] naipes) {
		this.cartas = new ArrayList<Carta>();
		for (int n = 0; n < naipes.length; n++) {
			for (int v = 0; v < valorDasCartas.length; v++) {
				cartas.add(new Carta(valorDasCartas[v], naipes[n]));
			}
		}
	}
	
	public void embaralhar() {
		Collections.shuffle(cartas);
	}
	
	public Carta getCarta() {
		return cartas.remove(cartas.size()-1);
	}
	
	public Carta visualisaCarta() {
		return cartas.get(cartas.size()-1);
	}
	
	public boolean estaVazio(){
		return cartas.size() <= 0;
	}
	
	public void colocaCarta(Carta novaCarta){
		cartas.add(novaCarta);
	}
	
	public int getQuantasCartas(){
		return cartas.size();
	}
	
	@Override
	public String toString(){
		String result = "";
		for(Carta c : cartas){
			result += c.toString()+",";
		}
		return result;
	}
}
