package webapp.jpa_school_project.Repository;


import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Administradores;

public interface AdmRepository extends CrudRepository<Administradores, Integer> {
    // criado para a busca de administradores por uma chave primária
    Administradores findByCpf(int cpf);
}
