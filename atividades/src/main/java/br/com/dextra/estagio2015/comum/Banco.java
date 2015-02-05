package br.com.dextra.estagio2015.comum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@SuppressWarnings("unused")
	private Banco() { }
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
}
