package academico;

import javax.persistence.*;

@Entity
public class Estudante {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;
    @ManyToOne
    @JoinColumn(name="CodCurso")
    private Curso Curso;
    private String Nome;
    private String Email;
    private String Matricula;


    public Estudante(){

    }

    public Estudante(Integer Id, Curso Curso, String Nome, String Email, String Matricula){

        this.Id = Id;
        this.Curso = Curso;
        this.Nome = Nome;
        this.Email = Email;
        this.Matricula = Matricula;

    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public String getEmail() {
        return Email;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
}
