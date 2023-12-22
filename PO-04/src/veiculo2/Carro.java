package veiculo2;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String modelo, String cor, int ano, int numeroPortas, boolean eletrico) {
        super(modelo, cor, ano, eletrico);
        this.numeroPortas = numeroPortas;
    }

    @Override
    public void ligar() {
        System.out.println("Carro ligado(a)");
    }

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando");
    }

    @Override
    public void parar() {
        System.out.println("Carro parado");
    }
}
