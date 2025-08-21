package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Integer>{
    Turma findById(int id_turma);
}
