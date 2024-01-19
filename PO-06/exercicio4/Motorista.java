import java.io.*;
import java.util.Date;

public class Motorista implements Serializable {
    private String nome;
    private Date inicioJornada;
    private Date fimJornada;

    public Motorista(String nome, Date inicioJornada, Date fimJornada) {
        this.nome = nome;
        this.inicioJornada = inicioJornada;
        this.fimJornada = fimJornada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInicioJornada() {
        return inicioJornada;
    }

    public void setInicioJornada(Date inicioJornada) {
        this.inicioJornada = inicioJornada;
    }

    public Date getFimJornada() {
        return fimJornada;
    }

    public void setFimJornada(Date fimJornada) {
        this.fimJornada = fimJornada;
    }

    public void iniciarTrajeto(Trajeto trajeto, PontoParada pontoParada) {
        System.out.println("Iniciando trajeto do motorista: " + nome);
        System.out.println("Próximo ponto de parada: " + pontoParada.getNome());
    }
}
