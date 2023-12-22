import java.util.Date;

public class Cobrador {
    private String nome;
    private Date inicioJornada;
    private Date fimJornada;

    public Cobrador(String nome, Date inicioJornada, Date fimJornada) {
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
}
