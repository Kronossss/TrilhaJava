package hierarquia;

public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String modelo, String cor, int ano, boolean partidaEletrica) {
        super(modelo, cor, ano);
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public void ligar() {
        System.out.println("Moto ligada");
    }

    @Override
    public void acelerar() {
        System.out.println("Moto acelerando");
    }

    @Override
    public void parar() {
        System.out.println("Moto parada");
    }

    public boolean hasPartidaEletrica() {
        return partidaEletrica;
    }
}
