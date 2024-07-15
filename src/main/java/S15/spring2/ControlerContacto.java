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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import S15.spring2.modelo.IContacto;
import S15.spring2.modelo.IproyInt;
import S15.spring2.modelo.proyInteres;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ControlerContacto {

    @Autowired
    private IContacto servicio;

    @GetMapping("/listarProyectos")

    public String listado(Model modelo) {
        modelo.addAttribute("listado", servicio.findAll());
        return "usuarios";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam("ids") List<Integer> ids, Model modelo) {
        // Eliminar los contactos por sus IDs
        servicio.deleteAllById(ids);

        // Agregar un mensaje de confirmación al modelo
        modelo.addAttribute("mensaje", "Contactos eliminados correctamente");

        modelo.addAttribute("listado", servicio.findAll());
        // Retornar la vista "usuarios"
        return "usuarios";
    }

    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model modelo) {
        modelo.addAttribute("listado", servicio.findAll());
        return "usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo) {
        Optional<Contacto> optionalContacto = servicio.findById(id);

        if (optionalContacto.isPresent()) {
            modelo.addAttribute("contact", optionalContacto.get());
            return "Editar";
        } else {
            // Manejar el caso donde el contacto no existe (puedes redirigir a una página de error o hacer otra acción apropiada)
            return "redirect:/usuarios"; // Ejemplo de redirección a la lista de usuarios
        }
    }

    @PostMapping("/editar")
    public String guardarEdicion(@ModelAttribute("contact") Contacto contact) {
        // Lógica para guardar los cambios en la base de datos
        servicio.save(contact);
        // Redirige a la página de usuarios después de guardar
        return "redirect:/usuarios";
    }

    @GetMapping("/new")
    public String agregar(Model modelo) {
        modelo.addAttribute("contacto", new Contacto());
        return "Agregar";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contacto contacto) {
        // Lógica para guardar el contacto
        servicio.save(contacto);
        return "redirect:/usuarios";
    }

    //A PARTIR DE AQUI ES PROYECTOS GUARDADOS
    @Autowired
    private IproyInt servicio2;

    @PostMapping("/eliminar2")
    public String eliminarGuadado(@RequestParam("ids") List<Integer> ids, Model modelo) {
        // Eliminar los contactos por sus IDs
        servicio2.deleteAllById(ids);

        // Agregar un mensaje de confirmación al modelo
        modelo.addAttribute("mensaje", "Proyecto sacado de mis guardados");

        modelo.addAttribute("listado2", servicio2.findAll());
        // Retornar la vista "guardados"
        return "guardados";
    }

    @GetMapping("/guardados")
    public String mostrarGuardados(Model modelo) {
        modelo.addAttribute("listado2", servicio2.findAll());
        return "guardados";
    }

    @GetMapping("/editar2/{id}")
    public String editar2(@PathVariable int id, Model modelo) {
        Optional<proyInteres> optionalContacto = servicio2.findById(id);

        if (optionalContacto.isPresent()) {
            modelo.addAttribute("contact", optionalContacto.get());
            List<String> opciones = Arrays.asList("Proyectos 2024", "Proyectos 2023", "Nivel Principantes", "Nivel Medio", "Nivel Avanzado", "Maquetas, Dibujos y Planos");
            modelo.addAttribute("opciones", opciones);
            return "Editar2";
        } else {
            // Manejar el caso donde el contacto no existe (puedes redirigir a una página de error o hacer otra acción apropiada)
            return "redirect:/guardados"; // Ejemplo de redirección a la lista de usuarios
        }
    }

    @PostMapping("/editar2")
    public String guardarEdicion2(@ModelAttribute("contact") proyInteres contact) {
        // Lógica para guardar los cambios en la base de datos
        servicio2.save(contact);
        // Redirige a la página de usuarios después de guardar
        return "redirect:/guardados";
    }

    @Controller
    public class TuControlador {

        @GetMapping("/newGuardado")
        public String agregarGuardado(Model modelo) {
            List<String> opciones = Arrays.asList(
                    "Proyectos 2024", "Proyectos 2023",
                    "Nivel Principantes", "Nivel Medio", "Nivel Avanzado",
                    "Maquetas, Dibujos y Planos"
            );
            modelo.addAttribute("opciones", opciones);
            modelo.addAttribute("proyInteres", new proyInteres()); // Inicializa proyInteres aquí
            return "Agregar2"; // Nombre de tu plantilla Thymeleaf (Agregar2.html)
        }

        // Otros métodos de tu controlador, como el método para procesar el formulario
    }

    @PostMapping("/save2")
    public String saveGuardado(@ModelAttribute("proyInteres") proyInteres proyecto) {
        // Lógica para guardar el proyecto
        servicio2.save(proyecto);
        return "redirect:/guardados";
    }

}
