package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String redirigir() {
        return "redirect:/admin";
    }

    @GetMapping("")
    public String inicio() {
        return  "admin/index";
    }
}
