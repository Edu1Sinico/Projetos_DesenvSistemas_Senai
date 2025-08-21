package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
    Aluno findByCpf(int cpf);
}

