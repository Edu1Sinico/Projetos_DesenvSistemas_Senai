package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
    Professor findByCpf(int cpf);
}
