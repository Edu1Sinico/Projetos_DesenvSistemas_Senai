package webapp.rhapp_jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import webapp.rhapp_jpa.Model.Funcionario;
import webapp.rhapp_jpa.Repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository fr;

    @RequestMapping(value = "/funcionario", method = RequestMethod.GET)
    public String abrirfuncionarior() {
        return "funcionarioView/funcionario";
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public String gravarfuncionario(Funcionario funcionario) {
        fr.save(funcionario);
        return "redirect:/";
    }
}
