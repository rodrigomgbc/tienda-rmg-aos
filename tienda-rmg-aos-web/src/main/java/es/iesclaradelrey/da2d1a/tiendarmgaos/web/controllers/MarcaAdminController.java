package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IMarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final IMarcaService marcaService;

    public MarcaAdminController(IMarcaService iMarcaService) {
        this.marcaService = iMarcaService;
    }

    @GetMapping("/")
    public String redirigir() {
        return "redirect:/admin/marcas";
    }

    @GetMapping("")
    public String listar(Model model) {
        model.addAttribute("marcas", marcaService.buscarTodos());
        return "admin/marcas/lista";
    }                          // <-- aquí cierra listar

    @GetMapping("/new")
    public String formularioNueva(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marcas/formulario";
    }

    @PostMapping("/new")
    public String guardarNueva(@ModelAttribute Marca marca, Model model) {
        try {
            marcaService.guardar(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/marcas/formulario";
        }
    }

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Marca> marca = marcaService.buscarPorId(id);
        if (marca.isEmpty()) {
            return "redirect:/admin/marcas";
        }
        model.addAttribute("marca", marca.get());
        return "admin/marcas/formulario";
    }

    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id,
                                 @ModelAttribute Marca marca,
                                 Model model) {
        try {
            marca.setId(id);
            marcaService.guardar(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/marcas/formulario";
        }
    }
}
