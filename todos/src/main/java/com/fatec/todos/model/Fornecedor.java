package com.fatec.todos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fornecedor")
public class Fornecedor {
	@Id
    private Long id;
    private String cnpj;
    private String nome;
    private String descricao;
    private String telefone;

    public Fornecedor(){}

    public Fornecedor(String cnpj, String nome, String descricao, String telefone){
        this.cnpj = cnpj;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    public String getCNPJ(){
        return cnpj;
    }
    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
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

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

}
