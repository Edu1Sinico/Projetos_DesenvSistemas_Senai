package webapp.jpa_school_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import webapp.jpa_school_project.Repository.AdmRepository;
import webapp.jpa_school_project.Repository.AlunoRepository;
import webapp.jpa_school_project.Repository.PreCadAdmRepository;
import webapp.jpa_school_project.Repository.ProfessorRepository;
import webapp.jpa_school_project.Repository.UsuarioLoginRepository;
import webapp.jpa_school_project.Model.Administradores;
import webapp.jpa_school_project.Model.Aluno;
import webapp.jpa_school_project.Model.Professor;
import webapp.jpa_school_project.Model.UsuarioLogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/* As informações são pegas pelo método "post" do formulário e colocadas no objeto adm da classe Administradores. 
As informações são gravadas com o objeto da classe admRepository, pois realiza o extendes os métodos do CrudRepository que posseum 
os métodos de banco de dados já prontos */

@Controller // Defição da classe de controller
public class UserController {
    // AdmRepository
    @Autowired // Tag do JPA para realizar o preenchimento de informações no bando de dados
    private AdmRepository ar; // Cria um objeto da classe repositório para ser possível realizar o cadastro no
                              // banco de dados

    // AlunoRepository
    @Autowired
    private AlunoRepository alr;

    // ProfessorRepository
    @Autowired
    private ProfessorRepository pr;

    // PreCadAdmRepository
    @Autowired
    private PreCadAdmRepository pcar;

    // UsuarioLogin
    // @Autowired
    // private UsuarioLogin uLogin;

    // UsuarioLoginRepository
    @Autowired
    private UsuarioLoginRepository uLoginR;

    @Autowired
    private HttpSession session;

    // Atributos
    private boolean acessoInternoAdm = false;
    private boolean acessoLogin = true;
    private boolean acessoAluno = false;
    private boolean acessoProf = false;
    private int cpf;

    @PostMapping("cadastro-user") // Criação da ação para o formulário (possuí um nome diferentes das rotas)
    public ModelAndView postCadastroUser(Administradores adm, Aluno aluno, Professor prof,
            @RequestParam("tipoUser") int tipoUser) { // Criar um objeto com as
        // informações da classe de
        // administradorm aluno ou professor

        ModelAndView mv = new ModelAndView("redirect:/cadastro"); // página login

        // boolean cpfVericacao = pcar.existsById(adm.getCpf()); // Armazena a busca do
        // cpf em uma
        // variável
        // if (cpfVericacao) { // Faz a verificação do se o CPF já está cadastrado.
        if (tipoUser == 0) {
            ar.save(adm); // Salvando as informações no banco de dados (Registrando o objeto
            // automáticamente por conta da Tag @AutoWired)
            uLoginR.save(new UsuarioLogin(adm.getCpf(), tipoUser)); // Armazena as informações de CPF e Tipo User do
                                                                    // usuário
            // administrador
        } else if (tipoUser == 1) {
            pr.save(prof);
            uLoginR.save(new UsuarioLogin(prof.getCpf(), tipoUser)); // Armazena as informações de CPF e Tipo User
                                                                     // do usuário aluno
        } else if (tipoUser == 2) {
            alr.save(aluno);
            uLoginR.save(new UsuarioLogin(aluno.getCpf(), tipoUser)); // Armazena as informações de CPF e Tipo User
                                                                      // do usuário professor
        }
        System.out.println("Cadastro realizado com sucesso");
        // } else {
        // System.out.println("Falha ao cadastrar");
        // }

        return mv; // retorna para a página de login
    }

    @PostMapping("acesso-user")
    public ModelAndView acessoLogin(@RequestParam Integer cpf,
            @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/");// página interna de acesso
        session.setAttribute("usuarioLogado", false);
        try {
            // Verifica se o CPF existe no banco de dados
            boolean acessoUserCpf = uLoginR.existsById(cpf);

            // Se o CPF existir, verifica se a senha está correta
            if (acessoUserCpf) {
                if (uLoginR.findByCpf(cpf).getTipoUser() == 0) {
                    boolean acessoSenhaAdm = senha.equals(ar.findByCpf(cpf).getSenha());

                    // Se o CPF e a senha forem válidos, concede acesso interno
                    if (acessoUserCpf && acessoSenhaAdm) {
                        acessoInternoAdm = true;
                        acessoLogin = false;
                        session.setAttribute("usuarioLogado", true);
                        cpf = ar.findByCpf(cpf).getCpf();
                        String nomeUsuario = ar.findByCpf(cpf).getNome();
                        mv.addObject("nomeUsuario", nomeUsuario);
                    } else {
                        // Se a senha estiver incorreta, exibe mensagem de erro e redireciona para login
                        String mensagem = "Senha incorreta";
                        System.out.println(mensagem);
                        attributes.addFlashAttribute("msg", mensagem);
                        attributes.addFlashAttribute("classe", "vermelho");
                        mv.setViewName("redirect:/login");
                    }
                } else if (uLoginR.findByCpf(cpf).getTipoUser() == 1) {
                    boolean acessoSenhaProf = senha.equals(alr.findByCpf(cpf).getSenha());

                    // Se o CPF e a senha forem válidos, concede acesso interno
                    if (acessoUserCpf && acessoSenhaProf) {
                        acessoProf = true;
                        acessoLogin = false;
                        session.setAttribute("usuarioLogado", true);
                        cpf = pr.findByCpf(cpf).getCpf();
                        String nomeUsuario = pr.findByCpf(cpf).getNome();
                        mv.addObject("nomeUsuario", nomeUsuario);
                    } else {
                        // Se a senha estiver incorreta, exibe mensagem de erro e redireciona para login
                        String mensagem = "Senha incorreta";
                        System.out.println(mensagem);
                        attributes.addFlashAttribute("msg", mensagem);
                        attributes.addFlashAttribute("classe", "vermelho");
                        mv.setViewName("redirect:/login");
                    }
                } else if (uLoginR.findByCpf(cpf).getTipoUser() == 2) {
                    boolean acessoSenhaAluno = senha.equals(alr.findByCpf(cpf).getSenha());

                    // Se o CPF e a senha forem válidos, concede acesso interno
                    if (acessoUserCpf && acessoSenhaAluno) {
                        acessoAluno = true;
                        acessoLogin = false;
                        session.setAttribute("usuarioLogado", true);
                        cpf = alr.findByCpf(cpf).getCpf();
                        String nomeUsuario = alr.findByCpf(cpf).getNome();
                        mv.addObject("nomeUsuario", nomeUsuario);
                    } else {
                        // Se a senha estiver incorreta, exibe mensagem de erro e redireciona para login
                        String mensagem = "Senha incorreta";
                        System.out.println(mensagem);
                        attributes.addFlashAttribute("msg", mensagem);
                        attributes.addFlashAttribute("classe", "vermelho");
                        mv.setViewName("redirect:/login");
                    }
                }
            } else {
                // Se o CPF não existir, exibe mensagem de erro e redireciona para login
                String mensagem = "CPF não encontrado";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/login");
            }

        } catch (Exception e) {
            // Se ocorrer qualquer exceção, exibe mensagem de erro genérica e redireciona
            // para login
            String mensagem = "Erro ao processar login";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/login");
        }

        return mv;
    }

    // Páginas de acesso

    @GetMapping("/login")
    // Rota para página interna de administração
    public ModelAndView acessoLogin(RedirectAttributes attributes) {

        // Cria um novo ModelAndView para a página interna de administração
        ModelAndView mv = new ModelAndView("login_cadastro/login");

        // Verifica se o login foi realizado
        if (acessoLogin) {
            System.out.println("Acesso Permitido");
        } else {
            // Se o login não foi realizado, exibe mensagem de erro e redireciona para login
            String mensagem = "Você já está logado!";
            System.out.println(mensagem);
            mv.setViewName("redirect:/");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }

        return mv;
    }

    @GetMapping("/cadastro")
    // Rota para página interna de administração
    public ModelAndView acessoCadastro(RedirectAttributes attributes) {

        // Cria um novo ModelAndView para a página interna de administração
        ModelAndView mv = new ModelAndView("login_cadastro/register");

        // Verifica se o login foi realizado
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
        } else {
            // Se o login não foi realizado, exibe mensagem de erro e redireciona para login
            String mensagem = "Você não tem permissão para entrar nesta página!";
            System.out.println(mensagem);
            mv.setViewName("redirect:/");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }
        return mv;
    }

    @GetMapping("/cadastro-conteudo")
    // Rota para página interna de administração
    public ModelAndView acessoCadastroConteudo(RedirectAttributes attributes) {

        // Cria um novo ModelAndView para a página interna de administração
        ModelAndView mv = new ModelAndView("cadastro-conteudo/registerSchool");

        // Verifica se o login foi realizado
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
        } else {
            // Se o login não foi realizado, exibe mensagem de erro e redireciona para login
            String mensagem = "Você não tem permissão para entrar nesta página!";
            System.out.println(mensagem);
            mv.setViewName("redirect:/");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }
        return mv;
    }
    

    @PostMapping("logout-user")
    // Rota para logout do administrador
    public ModelAndView logoutAdm() {

        // Cria um novo ModelAndView para redirecionar para a página interna de
        // administração após o logout
        ModelAndView mv = new ModelAndView("redirect:/");

        // Exibe mensagem de logout efetuado e define a variável de acesso como false
        acessoInternoAdm = false;
        acessoLogin = true;
        session.setAttribute("usuarioLogado", false);
        cpf = 0;
        return mv;
    }

}