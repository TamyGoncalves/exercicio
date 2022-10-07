package com.letscode.service;

import com.letscode.db.VeiculoDB;
import com.letscode.db.VeiculoDB;
import com.letscode.model.Veiculo;
import com.letscode.model.Veiculo;

import java.util.List;

public class VeiculoService {

    private VeiculoDB candidatoDB = new VeiculoDB();

    public static Veiculo buscarVeiculo(String codigo) {
        return null;
    }

    public Veiculo cadastrarVeiculo(String placa, String modelo, String marca, Integer codigo) {

        if (placa == null || placa.isEmpty()) {
            return null;
        }
        if (modelo == null || modelo.isEmpty()) {
            return null;
        }
        if (marca == null || marca.isEmpty()) {
            return null;
        }
        if (codigo == null || codigo < 0) {
            return null;
        }
        Veiculo veiculo = new Veiculo(placa, modelo, marca, codigo);
        return VeiculoDB.cadastrarVeiculo(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        VeiculoService veiculoDB = null;
        return veiculoDB.listarVeiculos();
    }



}
