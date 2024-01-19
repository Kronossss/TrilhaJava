import java.io.*;
import java.util.Date;


public class Checkpoint implements Serializable {
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

    public static void salvar(Checkpoint checkpoint) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("checkpoint.dat"))) {
            out.writeObject(checkpoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Checkpoint carregar() {
        Checkpoint checkpoint = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("checkpoint.dat"))) {
            checkpoint = (Checkpoint) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return checkpoint;
    }
}
