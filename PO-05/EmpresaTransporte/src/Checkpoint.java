import java.util.Date;

public class Checkpoint {
    private PontoParada pontoParada;
    private Date horarioChegada;

    public Checkpoint(PontoParada pontoParada, Date horarioChegada) {
        this.pontoParada = pontoParada;
        this.horarioChegada = horarioChegada;
    }

    public PontoParada getPontoParada() {
        return pontoParada;
    }

    public void setPontoParada(PontoParada pontoParada) {
        this.pontoParada = pontoParada;
    }

    public Date getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(Date horarioChegada) {
        this.horarioChegada = horarioChegada;
    }
}
