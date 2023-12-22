package hierarquia;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String modelo, String cor, int ano, int numeroPortas) {
        super(modelo, cor, ano);
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

    public int getNumeroPortas() {
        return numeroPortas;
    }
}
