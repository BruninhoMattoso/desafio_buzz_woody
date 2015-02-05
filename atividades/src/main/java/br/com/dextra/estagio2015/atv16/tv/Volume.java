package br.com.dextra.estagio2015.atv16.tv;

public class Volume {

	private static int MIN_VOLUME = 0;
	private static int MAX_VOLUME = 10;

	private int atual = MIN_VOLUME;

	public Volume(int volumeInicial) {
		check(volumeInicial);
		this.atual = volumeInicial;
	}

	public void abaixar() {
		check(this.atual -1);
		
		this.atual--;
	}

	public void aumentar() {
		check(this.atual +1);
		
		this.atual++;
	}

	public int getAtual() {
		return this.atual;
	}
	
	private static void check(int v) {
		if (v < MIN_VOLUME || v > MAX_VOLUME) {
			throw new RuntimeException("Valor errado para o volume " + v);
		}
	}

}
