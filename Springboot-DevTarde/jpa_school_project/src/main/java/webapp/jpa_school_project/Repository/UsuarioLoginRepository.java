package webapp.jpa_school_project.Repository;

import webapp.jpa_school_project.Model.UsuarioLogin;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioLoginRepository extends CrudRepository<UsuarioLogin, Integer>{
    // criando um método de busca do chave primária do CPF do usuário
    UsuarioLogin findByCpf(int cpf);
}
