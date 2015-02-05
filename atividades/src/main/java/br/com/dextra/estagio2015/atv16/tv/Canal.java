package br.com.dextra.estagio2015.atv16.tv;

public class Canal {

	private static int MIN_CANAL = 0;
	private static int MAX_CANAL = 60;
	
	private int atual = MIN_CANAL;
	
	public Canal(int canalInicial) {
		check(canalInicial);
		
		this.atual = canalInicial;
	}
	
	public void proximo() {
		check(this.atual +1);
		
		this.atual++;
	}
	
	public void anterior() {
		check(this.atual -1);
		
		this.atual--;
	}
	
	public int getAtual() {
		return atual;
	}
	
	private static void check(int c) {
		if (c < MIN_CANAL || c > MAX_CANAL) {
			throw new RuntimeException("Canal errado " + c);
		}
	}
	
}
