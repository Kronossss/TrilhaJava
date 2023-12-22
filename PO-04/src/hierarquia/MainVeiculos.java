package hierarquia;


public class MainVeiculos {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("VeiculoGenérico", "Preto", 2022);
        Carro carro = new Carro("Fusca", "Azul", 1980, 2);
        Moto moto = new Moto("CG125", "Vermelha", 2021, true);

        System.out.println("Informações do Veiculo:");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Cor: " + veiculo.getCor());
        System.out.println("Ano: " + veiculo.getAno());
        veiculo.ligar();
        veiculo.acelerar();
        veiculo.parar();
        System.out.println();

        System.out.println("Informações do Carro:");
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Ano: " + carro.getAno());
        System.out.println("Número de Portas: " + carro.getNumeroPortas());
        carro.ligar();
        carro.acelerar();
        carro.parar();
        System.out.println();

        System.out.println("Informações da Moto:");
        System.out.println("Modelo: " + moto.getModelo());
        System.out.println("Cor: " + moto.getCor());
        System.out.println("Ano: " + moto.getAno());
        System.out.println("Partida Elétrica: " + (moto.hasPartidaEletrica() ? "Sim" : "Não"));
        moto.ligar();
        moto.acelerar();
        moto.parar();
    }
}
