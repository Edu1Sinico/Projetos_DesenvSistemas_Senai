package webapp.jpa_school_project.Model;

import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

@Entity // Tag que realiza a criação do banco de dados
public class SituacaoAluno {
    @Id
    private int cpfAluno;
    private float nota1;
    private float nota2;
    private float nota3;
    private float media;
    private int qtdeFaltas;
    private boolean situacao;

    public int getCpfAluno() {
        return cpfAluno;
    }
    public void setCpfAluno(int cpfAluno) {
        this.cpfAluno = cpfAluno;
    }
    public float getNota1() {
        return nota1;
    }
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }
    public float getNota2() {
        return nota2;
    }
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
    public float getNota3() {
        return nota3;
    }
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
    public float getMedia() {
        return media;
    }
    public void setMedia(float media) {
        this.media = media;
    }
    public int getQtdeFaltas() {
        return qtdeFaltas;
    }
    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }
    public boolean isSituacao() {
        return situacao;
    }
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
