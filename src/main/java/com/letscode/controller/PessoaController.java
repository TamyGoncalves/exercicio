package com.letscode.controller;

import com.letscode.model.Pessoa;
import com.letscode.service.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PessoaController {

    private PessoaService pessoaService = new PessoaService();

    @GetMapping("/pessoa")
    public List<Pessoa> listarPessoas() {
        return pessoaService.listaPessoas();
    }

    @PostMapping("/pessoa")
    public void salvarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getCpf(), pessoa.getEndereco(), pessoa.getTelefone());
    }


}
