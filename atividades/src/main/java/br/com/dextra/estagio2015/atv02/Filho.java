package br.com.dextra.estagio2015.atv02;

public class Filho extends Pai {
	private String nome;
	
	public Filho(String nome) {
		this.nome = nome;
	}

	@Override
	public String abstrado() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!nome.isEmpty())
			this.nome = nome;
	}

}
