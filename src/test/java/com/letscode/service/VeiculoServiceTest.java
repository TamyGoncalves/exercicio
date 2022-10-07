package com.letscode.service;

import com.letscode.db.VeiculoDB;
import com.letscode.model.Veiculo;
import com.letscode.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.letscode.db.VeiculoDB.veiculos;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

    @InjectMocks
    private VeiculoService veiculoService;

    @Mock
    private VeiculoDB veiculoDB;

    @Test
    public void testCadastrarVeiculoSucesso() {

        Mockito.when(veiculoDB
                .cadastrarVeiculo(Mockito.any()))
                .thenReturn(new Veiculo("GH1DF563", "UNO", "FIAT", 100));

        Veiculo retorno = veiculoService
                .cadastrarVeiculo("GH1DF563", "UNO", "FIAT", 100);

        Assertions.assertEquals("GH1DF563", retorno.getPlaca());
        Assertions.assertEquals("UNO", retorno.getModelo());
        Assertions.assertEquals("FIAT", retorno.getMarca());
        Assertions.assertEquals(100, retorno.getCodigo());

    }

    @Test
    public void testCadastrarVeiculoErroNomeNull() {
        Veiculo retorno = veiculoService
                .cadastrarVeiculo(null, "UNO", "FIAT", 100);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testCadastrarVeiculoErroVotosNegativo() {
        Veiculo retorno = veiculoService
                .cadastrarVeiculo("GH1DF563", "UNO", "FIAT", -100);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testListarVeiculosListaVazia() {
        Mockito.when(veiculoDB.listarVeiculos())
                .thenReturn(new ArrayList<>());

        List<Veiculo> lista = veiculoService.listarVeiculos();
        Assertions.assertTrue(lista.isEmpty());
    }

    @Test
    public void testListarVeiculosSucesso() {
        List<Veiculo> veiculo = new ArrayList<>();
        List<Veiculo> veiculos = null;
        veiculos.add(new Veiculo("GH1DF563", "UNO", "FIAT", 100));
        veiculos.add(new Veiculo("LOJ5D856", "ABC", "Chevrolet", 50));

        Mockito.when(veiculoDB.listarVeiculos())
                .thenReturn(veiculos);

        List<Veiculo> retorno = veiculoService.listarVeiculos();
        Assertions.assertFalse(retorno.isEmpty());
        Assertions.assertEquals(2, retorno.size());
        Assertions.assertEquals("C1", retorno.get(0).getPlaca());
        Assertions.assertEquals("C2", retorno.get(1).getPlaca());
    }

  



    }


