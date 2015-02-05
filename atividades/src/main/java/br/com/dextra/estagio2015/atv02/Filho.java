package br.com.dextra.estagio2015.atv02;

public class Filho extends Pai {

	/**
	 * [WOODY] Adicionamos o parâmetro no construtor.
	 * @param nome
	 */
	
	public Filho(String nome) {
		this.nome = nome;
	}

	@Override
	public String abstrado() {
		return nome;
	}
}
