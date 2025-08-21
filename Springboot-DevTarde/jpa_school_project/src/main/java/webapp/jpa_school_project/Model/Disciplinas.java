package webapp.jpa_school_project.Model;

import java.io.Serializable;
import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

@Entity // Tag que realiza a criação do banco de dados
public class Disciplinas implements Serializable {
    @Id // Define a chave primária
    private int id_disciplina;
    private String nome_disciplina;

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }
}
