package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.PreCadastroAdm;


public interface PreCadAdmRepository extends CrudRepository<PreCadastroAdm, Integer> {
    // criado para a busca de administradores por uma chave primária
    PreCadastroAdm findById(int cpf);

    PreCadastroAdm findBySenha(String senha);
}
