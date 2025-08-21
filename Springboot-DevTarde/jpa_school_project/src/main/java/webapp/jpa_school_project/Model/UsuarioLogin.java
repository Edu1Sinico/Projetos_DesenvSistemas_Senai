package webapp.jpa_school_project.Model;

import java.io.Serializable;
import jakarta.persistence.*; // Permite com que eu utilize as tags de persistencia (@Entity, @ID, etc.)

// Classe de controle de login dos usuários, ele irá armazenar as informações de CPF e do tipo de usuário cadastrados
@Entity // Tag que realiza a criação do banco de dados
public class UsuarioLogin implements Serializable {
    @Id // Define a chave primária
    private int cpf;
    private int tipoUser;
    
    public UsuarioLogin(){}

    public UsuarioLogin(int cpf, int tipoUser) {
        this.cpf = cpf;
        this.tipoUser = tipoUser;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }
}
