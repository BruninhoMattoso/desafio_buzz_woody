package br.com.dextra.estagio2015.comum;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;
	
	@OneToMany
	private List<Conta> contas = new ArrayList<Conta>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return this.contas;
	}

	public Long getId() {
		return id;
	}

	public void addConta(Conta conta) {
		if (conta.getSaldo() < 0)
			throw new RuntimeException("Não pode!");
			
		this.contas.add(conta);
	}

}
