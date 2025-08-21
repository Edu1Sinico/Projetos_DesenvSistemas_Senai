package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Disciplinas;

public interface DisciplinasRepository extends CrudRepository<Disciplinas, Integer>{
    Disciplinas findById(int id_disciplina);
}
