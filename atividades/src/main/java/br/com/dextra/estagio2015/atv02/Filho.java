package br.com.dextra.estagio2015.atv02;

public class Filho extends Pai {

	/**
	 * [WOODY] Adicionamos o parâmetro no construtor.
	 * Alteramos o nome do método abstrado
	 * @param nome
	 */
	
	public Filho(String nome) {
		this.nome = nome;
	}

	@Override
	public String getNome() {
		return nome;
	}
}
