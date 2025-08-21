package webapp.jpa_school_project.Model;

import java.io.Serializable;
import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

@Entity // Tag que realiza a criação do banco de dados
public class Aluno implements Serializable {
    @Id // Define a chave primária
    private int cpf;
    private String nome;
    private String email;
    private String senha;
    private int tipoUser;
    private String disciplina;
    private String turma;
    private String curso;
    private boolean situacao;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }   
}
