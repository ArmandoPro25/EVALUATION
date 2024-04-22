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
import mx.utng.jarm.model.entity.Bitacora;
import mx.utng.jarm.model.service.IBitacoraService;

@Controller
@SessionAttributes("bitacora")
public class BitacoraController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IBitacoraService bitacoraService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/bitacora/list","/bitacora","/bitacora/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Bitacoras");
    model.addAttribute("bitacoras", bitacoraService.list());
    return "blist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/bitacora/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Bitacoras");
        model.addAttribute("bitacora", new Bitacora());
        return "bform";
    }

    @GetMapping("/bitacora/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Bitacora bitacora = null;
        if (id>0) {
            bitacora = bitacoraService.getById(id);
        }else{
            return "redirect:blist";
        }

        model.addAttribute("title", "Editar Bitacora");
        model.addAttribute("bitacora", bitacora);
        return "bform";
    }


    @PostMapping ("/bitacora/form")
    public String save(@Valid Bitacora bitacora, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Bitacoras");
            return "bform";
        }

        bitacoraService.save(bitacora);
        return "redirect:/bitacora/list";
    }

    @GetMapping("/bitacora/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            bitacoraService.delete(id);
        }
        return "redirect:/bitacora/list";
    }

}

