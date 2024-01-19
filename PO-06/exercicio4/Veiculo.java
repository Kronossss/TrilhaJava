import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Veiculo implements Serializable {
    private String placa;
    private String modelo;
    private List<PontoParada> pontosEstacionados;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.pontosEstacionados = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<PontoParada> getPontosEstacionados() {
        return pontosEstacionados;
    }

    public void estacionar(PontoParada pontoParada) {
        System.out.println("Veículo estacionado em: " + pontoParada.getNome());
        pontosEstacionados.add(pontoParada);
    }
}
