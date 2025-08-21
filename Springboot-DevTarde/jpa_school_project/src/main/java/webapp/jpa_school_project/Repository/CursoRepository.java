package webapp.jpa_school_project.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_school_project.Model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer>{
    Curso findById(int id_curso);
}
