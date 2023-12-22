package veiculo2;

public class MainGaragem {
    public static void main(String[] args) {
        Garagem garagem = new Garagem(true);

        Veiculo veiculo = new Veiculo("VeiculoGenérico", "Preto", 2022, false);
        Carro carro = new Carro("Fusca", "Azul", 1980, 2, false);
        Moto moto = new Moto("CG125", "Vermelha", 2021, true, true);

        veiculo.estacionar(garagem);
        System.out.println();

        carro.estacionar(garagem);
        System.out.println();

        moto.estacionar(garagem);
    }
}
