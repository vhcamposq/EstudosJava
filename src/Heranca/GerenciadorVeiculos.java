package Heranca;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorVeiculos {
    private List<Veiculo> veiculos;

    public GerenciadorVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
        }
    }
}
