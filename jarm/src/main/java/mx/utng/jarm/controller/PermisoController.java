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
import mx.utng.jarm.model.entity.Permiso;
import mx.utng.jarm.model.service.IPermisoService;

@Controller
@SessionAttributes("permiso")
public class PermisoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IPermisoService permisoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/permiso/list","/permiso","/permiso/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Permisos");
    model.addAttribute("permisos", permisoService.list());
    return "plist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/permiso/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Permisos");
        model.addAttribute("permiso", new Permiso());
        return "pform";
    }

    @GetMapping("/permiso/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Permiso permiso = null;
        if (id>0) {
            permiso = permisoService.getById(id);
        }else{
            return "redirect:plist";
        }

        model.addAttribute("title", "Editar Permiso");
        model.addAttribute("permiso", permiso);
        return "pform";
    }


    @PostMapping ("/permiso/form")
    public String save(@Valid Permiso permiso, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Permisos");
            return "pform";
        }

        permisoService.save(permiso);
        return "redirect:/permiso/list";
    }

    @GetMapping("/permiso/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            permisoService.delete(id);
        }
        return "redirect:/permiso/list";
    }

}

