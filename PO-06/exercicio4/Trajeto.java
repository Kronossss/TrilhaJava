import java.io.*;
import java.util.List;

public class Trajeto implements Serializable {
    private List<Trecho> trechos;

    public Trajeto(List<Trecho> trechos) {
        this.trechos = trechos;
    }

    public List<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(List<Trecho> trechos) {
        this.trechos = trechos;
    }
}
