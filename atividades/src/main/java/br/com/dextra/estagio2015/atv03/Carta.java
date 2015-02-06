package br.com.dextra.estagio2015.atv03;

public class Carta {
	private int valor;
	private char naipe;

	public Carta(int valor, char naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	public Carta(int valor) {
		this.valor = valor;
		this.naipe = ' ';
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public char getNaipe() {
		return naipe;
	}

	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}

	@Override
	public String toString() {
		return "Carta [valor=" + valor + ", naipe=" + naipe + "]";
	}
}
