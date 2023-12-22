package veiculo2;

import java.util.ArrayList;

public class Garagem {
    private ArrayList<Veiculo> veiculos;
    private boolean tomadaEletrica;

    public Garagem(boolean tomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.tomadaEletrica = tomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean temTomadaEletrica() {
        return tomadaEletrica;
    }
}
