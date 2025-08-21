package webapp.jpa_school_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.jpa_school_project.Model.Curso;
import webapp.jpa_school_project.Model.Disciplinas;
import webapp.jpa_school_project.Model.Turma;
import webapp.jpa_school_project.Repository.CursoRepository;
import webapp.jpa_school_project.Repository.DisciplinasRepository;
import webapp.jpa_school_project.Repository.TurmaRepository;

@Controller
public class SchoolContentController {

    @Autowired
    private CursoRepository cr;

    @Autowired
    private TurmaRepository tr;

    @Autowired
    private DisciplinasRepository dr;

    // Método para listar os cursos
    @GetMapping("/listar-cursos")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cr.findAll());
        return "fragmentos/listar-cursos";
    }

    // Método para listar as turmas
    @GetMapping("/listar-turmas")
    public String listarTurmaString(Model model) {
        model.addAttribute("turmas", tr.findAll());
        return "fragmentos/listar-turmas";
    }

    // Método para listar as disciplinas
    @GetMapping("/listar-disciplinas")
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", dr.findAll());
        return "fragmentos/listar-disciplinas";
    }

    // Método para cadastrar turmas, cursos e disciplinas
    @PostMapping("cadastro-conteudo") // Criação da ação para o formulário (possuí um nome diferentes das rotas)
    public ModelAndView postCadastroUser(Curso curso, Turma turma, Disciplinas disc,
            @RequestParam("tipoConteudo") int tipoConteudo) {

        ModelAndView mv = new ModelAndView("redirect:/cadastro-conteudo"); // página login

        // Curso
        if (tipoConteudo == 0) {
            cr.save(curso);
        } else if (tipoConteudo == 1) { // Turma
            tr.save(turma);
        } else if (tipoConteudo == 2) { // Disciplinas
            dr.save(disc);
        }
        System.out.println("Cadastro de conteúdo realizado com sucesso");

        return mv;
    }

}
