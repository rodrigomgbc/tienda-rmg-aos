package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final ICategoriaService categoriaService;

    public CategoriaAdminController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String redirigir() {
        return "redirect:/admin/categorias";
    }

    @GetMapping("")
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "admin/categorias/lista";
    }

    @GetMapping("/new")
    public String formularioNueva(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/formulario";
    }

    @PostMapping("/new")
    public String guardarNueva(@ModelAttribute Categoria categoria, Model model) {
        try {
            categoriaService.guardar(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/categorias/formulario";
        }
    }
}
