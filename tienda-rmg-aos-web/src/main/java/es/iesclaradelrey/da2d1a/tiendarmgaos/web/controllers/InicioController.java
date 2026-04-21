package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controller que gestiona la página de inicio (la raíz "/").
// @Controller -> le dice a Spring que esto maneja peticiones web.
@Controller
public class InicioController {

    // Cuando alguien entra en "/" o en "" Spring llama a este método.
    // Devolver "index" significa: busca la plantilla templates/index.html
    // y muéstrala.
    @GetMapping({"/", ""})
    public String inicio(){
        return "index";
    }
}
