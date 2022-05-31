package com.fatec.todos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Fornecedor {
	@Id
    private String id;
    @SuppressWarnings("unused")
	private String cnpj;
    @SuppressWarnings("unused")
	private String nome;
    @SuppressWarnings("unused")
	private String descricao;
    @SuppressWarnings("unused")
	private String telefone;
}
