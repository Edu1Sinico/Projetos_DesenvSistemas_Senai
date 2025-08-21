package webapp.jpa_school_project.Model;

import java.io.Serializable;
import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

@Entity // Tag que realiza a criação do banco de dados
public class Turma implements Serializable {

    @Id
    private int id_turma;
    private String ano_turma;

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getAno_turma() {
        return ano_turma;
    }

    public void setAno_turma(String ano_turma) {
        this.ano_turma = ano_turma;
    }
}
