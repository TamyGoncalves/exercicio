package com.letscode.db;

import com.letscode.model.Veiculo;
import com.letscode.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDB {

    public static List<Veiculo> veiculos = new ArrayList<>();

    public static Veiculo cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public <Veiculo> Veiculo buscarVeiculo(String placa) {
        Optional<Veiculo> optional = (Optional<Veiculo>) veiculos
                .stream()
                .filter(veiculo -> veiculo.getPlaca().equals(placa))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

}
