package webapp.jpa_school_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webapp.jpa_school_project.Repository.AlunoRepository;

@Controller
public class ProfessorController {
   
    @Autowired
    private AlunoRepository ar;

    @GetMapping("/listar-alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", ar.findAll());
        return "professorView/listar-alunos";
    }
}
