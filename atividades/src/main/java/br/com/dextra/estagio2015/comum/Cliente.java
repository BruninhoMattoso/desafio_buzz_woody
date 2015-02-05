package br.com.dextra.estagio2015.comum;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	
	@OneToMany(targetEntity=Conta.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Conta> contas;

	@SuppressWarnings("unused")
	private Cliente() {
	}
	
	public Cliente(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<Conta>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<Conta> getContas() {
		System.out.println("Oi, eu tenho uma conta, e a 0 é: "+this.contas.get(0));
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
