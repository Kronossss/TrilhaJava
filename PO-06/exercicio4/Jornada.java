import java.io.*;
import java.util.List;

public class Jornada implements Serializable {
    private List<Trajeto> trajetos;
    private Motorista motorista;
    private Cobrador cobrador;
    private Veiculo veiculo;

    public Jornada(List<Trajeto> trajetos, Motorista motorista, Cobrador cobrador, Veiculo veiculo) {
        this.trajetos = trajetos;
        this.motorista = motorista;
        this.cobrador = cobrador;
        this.veiculo = veiculo;
    }

    public List<Trajeto> getTrajetos() {
        return trajetos;
    }

    public void setTrajetos(List<Trajeto> trajetos) {
        this.trajetos = trajetos;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Cobrador getCobrador() {
        return cobrador;
    }

    public void setCobrador(Cobrador cobrador) {
        this.cobrador = cobrador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
