package dto;

public class EstudanteDTO {

    private String Nome;

    private String Matricula;

    private String Email;

    private String Curso;

    public EstudanteDTO(){

    }

    public EstudanteDTO(String Nome, String Matricula, String Email, String Curso){
        this.Nome = Nome;
        this.Matricula = Matricula;
        this.Email = Email;
        this.Curso = Curso;
    }

    public String getNome() {
        return Nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public String getEmail() {
        return Email;
    }

    public String getCurso() {
        return Curso;
    }

    public void setEmail(String Email) {
        Email = Email;
    }

    public void setNome(String Nome) {
        Nome = Nome;
    }

    public void setMatricula(String Matricula) {
        Matricula = Matricula;
    }

    public void setCurso(String Curso) {
        Curso = Curso;
    }
}

