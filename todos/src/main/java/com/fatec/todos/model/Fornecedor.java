package com.fatec.todos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Fornecedor {
	@Id
    private String id;
    private String cnpj;
    private String nome;
    private String descricao;
    private String telefone;
}
