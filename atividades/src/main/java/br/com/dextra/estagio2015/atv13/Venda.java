package br.com.dextra.estagio2015.atv13;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "teste")
	private Long id;

	@Column(length = 50)
	private String nomeCliente;
	
	@Column(length = 50)
	private String enderecoEntrega;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> itens = new ArrayList<ItemVenda>();
	
	public void add(ItemVenda item) {
		itens.add(item);
	}

	public final Long getId() {
		return id;
	}

	public final List<ItemVenda> getItens() {
		return itens;
	}

	public final String getNomeCliente() {
		return nomeCliente;
	}

	public final void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public final String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public final void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
}
