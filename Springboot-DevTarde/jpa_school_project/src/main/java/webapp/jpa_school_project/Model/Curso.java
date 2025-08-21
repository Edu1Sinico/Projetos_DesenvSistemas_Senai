package webapp.jpa_school_project.Model;

import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

@Entity // Tag que realiza a criação do banco de dados
public class Curso {
    @Id
    private int id_curso;
    private String nome_curso;

    public int getId_curso() {
        return id_curso;
    }
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    public String getNome_curso() {
        return nome_curso;
    }
    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }
}
