package webapp.jpa_school_project.Controller.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// Classe de navegação de páginas
@Controller // Defição da classe de controller
public class IndexController {
    
    @GetMapping("/")
    public String acessoHome() {
        return "index";
    }

    @GetMapping("/home")
    public String acessoHome2() {
        return "index";
    }
}
