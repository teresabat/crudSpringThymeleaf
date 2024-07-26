package teresa.bat.crud.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import teresa.bat.crud.spring.model.Usuario;
import teresa.bat.crud.spring.service.UsuarioService;

@Controller
public class FrontendController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuario", usuarioService.getAllUsuario());
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/";
    }
}
