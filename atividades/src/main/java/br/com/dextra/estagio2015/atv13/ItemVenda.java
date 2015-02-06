package br.com.dextra.estagio2015.atv13;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Double valor;

	public ItemVenda() {
	}
	
	public ItemVenda(Double valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public Double getValor() {
		return valor;
	}
}
