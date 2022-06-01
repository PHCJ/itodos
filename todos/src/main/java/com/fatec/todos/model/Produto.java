package com.fatec.todos.model;

import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produto")
public class Produto {
	@Id
    private String id;
	@NotBlank(message = "O código de barras do produto é obrigatório")
    private String codBarras;
    private String nome;
    private String descricao;
    private String cor;
    private String tamanho;
    private int quantidade;
	private double custo;

    public Produto() {}
	
	public Produto(String codBarras, String nome, String descricao, String cor, String tamanho, int quantidade, double custo) {
		this.codBarras = codBarras;
		this.nome = nome;
		this.descricao = descricao;
		this.cor = cor;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.custo = custo;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getCusto() {
		return custo;
	}	
}
