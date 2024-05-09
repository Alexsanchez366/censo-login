
package com.registro.usuarios.controlador;


import com.registro.usuarios.modelo.personas;
import com.registro.usuarios.servicio.personaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class personaController {
    
    @Autowired
    private personaService personaService;
    
   @RequestMapping("/")
    public String seeHomePaging(Model modelo, @Param("keyword")String keyword){
        List<personas> listaPersona = personaService.listAll(keyword);
        int totalHabitantes = personaService.getTotalHabitantes();
        modelo.addAttribute("listaPersona", listaPersona);
        modelo.addAttribute("keyword", keyword);
        modelo.addAttribute("totalHabitantes", totalHabitantes); 
        return "index";
    
    }
    
    @RequestMapping("/new")
    public String showRegistrationForm(Model modelo){
        personas personas = new personas();
        modelo.addAttribute("personas", personas);
    return "nuevo_Censo";
    }
    
    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveCenso(@ModelAttribute("personas") personas personas){
       personaService.save(personas);
       return "redirect:/";
    }
    
     @RequestMapping("/edit/{id}")
    public ModelAndView showEditform(@PathVariable(name = "id") int id){
       ModelAndView modelo = new ModelAndView("edit_Personas");
       personas personas = personaService.get(id);
       modelo.addObject("personas", personas);
       return modelo;
    }
    

    
}
