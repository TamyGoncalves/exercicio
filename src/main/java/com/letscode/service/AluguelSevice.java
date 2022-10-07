package com.letscode.service;

import com.letscode.model.Aluguel;
import com.letscode.model.Pessoa;
import com.letscode.model.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AluguelSevice {

    private static List<Aluguel> aluguel = new ArrayList<>();

    private PessoaService pessoaService = new PessoaService();
    private VeiculoService veiculoService = new VeiculoService();

    public Aluguel cadastrarAluguel(String cpf, String codigo) {
        Pessoa pessoa = pessoaService.buscaPessoa(cpf);
        if (pessoa == null) {
            return null;
        }

        Veiculo veiculo = VeiculoService.buscarVeiculo(codigo);
        if (veiculo == null) {
            return null;
        }

        LocalDate dataAluguel = LocalDate.now();
        LocalDate dataDevolucao = dataAluguel.plusDays(7);

        Aluguel aluguel = new Aluguel(veiculo, pessoa, dataAluguel, dataDevolucao);
        aluguel.add(aluguel);
        return aluguel;
    }

    public List<Aluguel> listarEmprestimos() {
        return aluguel;
    }

    public boolean finalizarEmprestimo(String cpf) {
        Optional<Aluguel> aluguel = alugueis
                .stream()
                .filter(e -> e.getPessoa().getCpf().equals(cpf))
                .findFirst();

        if (aluguel.isPresent()) {
            Aluguel emp = aluguel.get();
            aluguel.remove(emp);
            return true;
        }
        return false;
    }



}

