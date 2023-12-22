import java.util.Arrays;
import java.util.Date;

public class MainTransporte {
    public static void main(String[] args) {
        PontoParada pontoOrigem = new PontoParada("Terminal A");
        PontoParada pontoDestino = new PontoParada("Terminal B");

        Trecho trecho = new Trecho(pontoOrigem, pontoDestino, 30);
        Trajeto trajeto = new Trajeto(Arrays.asList(trecho));

        Veiculo veiculo = new Veiculo("ABC123", "Modelo X");
        Motorista motorista = new Motorista("João", new Date(), new Date());
        Cobrador cobrador = new Cobrador("Maria", new Date(), new Date());

        Jornada jornada = new Jornada(Arrays.asList(trajeto), motorista, cobrador, veiculo);

        PontoParada checkpointParada = new PontoParada("Ponto de Checkpoint");
        Checkpoint checkpoint = new Checkpoint(checkpointParada, new Date());

        jornada.getVeiculo().estacionar(checkpointParada);
        jornada.getMotorista().iniciarTrajeto(trajeto, checkpointParada);
    }
}
