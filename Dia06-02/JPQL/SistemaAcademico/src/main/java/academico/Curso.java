package academico;

import javax.persistence.*;
import java.util.List;


@Entity
public class Curso {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nome;
    private Integer NumSemestres;
    @OneToMany (mappedBy="Curso")
    List<Estudante> listaEstudantes;

    public Curso(){
    }

    public Curso(Integer Id, String Nome, Integer NumSemestres){

        this.Id = Id;
        this.Nome = Nome;
        this.NumSemestres = NumSemestres;

    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNumSemestres(Integer numSemestres) {
        NumSemestres = numSemestres;
    }

    public Integer getNumSemestres() {
        return NumSemestres;
    }
}
