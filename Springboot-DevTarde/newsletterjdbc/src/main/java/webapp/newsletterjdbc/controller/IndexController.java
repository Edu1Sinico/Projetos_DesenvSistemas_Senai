package webapp.newsletterjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.newsletterjdbc.connection.IndexDAO;
import webapp.newsletterjdbc.model.IndexModel;

@Controller
public class IndexController {
    private List<IndexModel> listarEmails;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        new IndexDAO().criaTabela();

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView enviarEmailBanco(@RequestParam("email") String email) {
        ModelAndView mv = new ModelAndView("index");

        listarEmails = new IndexDAO().selecionarTodos();

        for (IndexModel emails : listarEmails) {
            if (email.equals(emails)) {
                String mensagem = "Email já cadastrado!";
                mv.addObject("msg", mensagem);
            } else {
                new IndexDAO().cadastrar(email);
                break;
            }
        }

        return mv;
    }
}