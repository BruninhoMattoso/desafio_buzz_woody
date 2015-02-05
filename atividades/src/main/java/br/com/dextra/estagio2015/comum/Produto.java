package br.com.dextra.estagio2015.comum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.dextra.estagio2015.atv07.TipoProduto;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column
	private String descricao;

	@Column
	private double preco;

	@Column
	private double peso;

	@Column
	private double altura;

	@Column
	private double largura;

	@Column
	private double comprimento;

	@Column
	@Enumerated(EnumType.STRING)
	private TipoProduto tipoProduto;

	@Column
	private Boolean promocao;

	public Produto() {
	}

	public Produto(String nome, String descricao, double preco, double peso, double altura, double largura,
			double comprimento, TipoProduto tipoProduto, Boolean promocao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.tipoProduto = tipoProduto;
		this.promocao = promocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double d) {
		this.altura = d;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

}
