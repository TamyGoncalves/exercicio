package com.letscode.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
    }
}

