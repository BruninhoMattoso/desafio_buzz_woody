package br.com.dextra.estagio2015.comum;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banco {

	@Id
	private Long id;
	
	private String nome;

	private Banco() { }
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
}
