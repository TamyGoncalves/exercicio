package com.letscode.controller;

import com.letscode.model.Veiculo;
import com.letscode.model.Veiculo;
import com.letscode.service.VeiculoService;
import com.letscode.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VeiculosController {

    private VeiculoService veiculoService = new VeiculoService();

    @GetMapping("/veiculo")
    public List<Veiculo> listVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @PostMapping("/veiculo")
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(
                veiculo.getPlaca(), veiculo.getModelo(), veiculo.getMarca(), veiculo.getCodigo()
        );
    }

}
