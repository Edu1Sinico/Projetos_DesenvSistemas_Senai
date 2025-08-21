package webapp.jpa_school_project.Model;

import java.io.Serializable;
import jakarta.persistence.*; 

@Entity 
public class PreCadastroAdm implements Serializable{
    @Id
    private int cpf;
    private String senha;

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
