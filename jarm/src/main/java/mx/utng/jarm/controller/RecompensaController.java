package mx.utng.jarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.jarm.model.entity.Recompensa;
import mx.utng.jarm.model.service.IRecompensaService;

@Controller
@SessionAttributes("recompensa")
public class RecompensaController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IRecompensaService recompensaService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/recompensa/list","/recompensa","/recompensa/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Recompensas");
    model.addAttribute("recompensas", recompensaService.list());
    return "rlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/recompensa/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Recompensas");
        model.addAttribute("recompensa", new Recompensa());
        return "rform";
    }

    @GetMapping("/recompensa/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Recompensa recompensa = null;
        if (id>0) {
            recompensa = recompensaService.getById(id);
        }else{
            return "redirect:rlist";
        }

        model.addAttribute("title", "Editar Recompensa");
        model.addAttribute("recompensa", recompensa);
        return "rform";
    }


    @PostMapping ("/recompensa/form")
    public String save(@Valid Recompensa recompensa, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Recompensas");
            return "rform";
        }

        recompensaService.save(recompensa);
        return "redirect:/recompensa/list";
    }

    @GetMapping("/recompensa/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            recompensaService.delete(id);
        }
        return "redirect:/recompensa/list";
    }

}

