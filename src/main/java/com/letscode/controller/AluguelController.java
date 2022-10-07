package com.letscode.controller;

import com.letscode.model.Aluguel;
import com.letscode.model.DadoAluguel;
import com.letscode.service.AluguelSevice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AluguelController {

    private AluguelService aluguelService = new AluguelService();

    @GetMapping("/aluguel")
    public List<Aluguel> listarAlugueis() {
        return aluguelService.listarAlgueis();
    }

    @PostMapping("/aluguel")
    public void salvarAlugueis(@RequestBody DadoAluguel aluguel) {
        AluguelSevice alguelService = null;
        alguelService.cadastrarAluguel(aluguel.getCpf(), aluguel.getCodigo());
    }

}

