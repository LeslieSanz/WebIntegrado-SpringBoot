/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package S15.spring2;
//
import S15.spring2.modelo.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import S15.spring2.modelo.IContacto;

@Controller
@RequestMapping("/")
public class ControlerContacto {
    @Autowired
    private IContacto servicio;
    private Contacto contac;
    @GetMapping("/listarProyectos")
    public String listado(Model modelo){
        modelo.addAttribute("listado", servicio.findAll());
        double sm=0;
        for(Contacto x:servicio.findAll()){
            sm+=1;
        }
        
        modelo.addAttribute("total",sm);
        return "menu";
    }
    
    @GetMapping("/usuarios")
    public String mostrarUsuarios() {
        return "usuarios"; // Esto se refiere al nombre de tu archivo usuarios.html
    }
    
    @PostMapping("/saveProyectos")
    public String graba(@Validated Contacto p, Model modelo){
        servicio.save(p);
        modelo.addAttribute("proyecto", new Contacto());
        return "redirect:/listar";
    }
   
    
}
