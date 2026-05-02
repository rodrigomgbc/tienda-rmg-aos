package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        if (categoria.isEmpty()) {
            return "redirect:/admin/categorias";
        }
        model.addAttribute("categoria", categoria.get());
        return "admin/categorias/formulario";
    }

    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id,
                                 @ModelAttribute Categoria categoria,
                                 Model model) {
        try {
            categoria.setId(id);
            categoriaService.guardar(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/categorias/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String formularioEliminar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        if (categoria.isEmpty()) {
            return "redirect:/admin/categorias";
        }
        model.addAttribute("categoria", categoria.get());
        return "admin/categorias/eliminar";
    }

    @PostMapping("/{id}/delete")
    public String eliminar(@PathVariable Long id, Model model) {
        try {
            Optional<Categoria> categoria = categoriaService.buscarPorId(id);
            if (categoria.isEmpty()) {
                return "redirect:/admin/categorias";
            }
            if (!categoria.get().getProductos().isEmpty()) {
                model.addAttribute("categoria", categoria.get());
                model.addAttribute("error", "No se puede eliminar la categoría \""
                        + categoria.get().getNombre()
                        + "\" porque tiene productos asociados.");
                return "admin/categorias/eliminar";
            }
            categoriaService.eliminarPorId(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            Optional<Categoria> categoria = categoriaService.buscarPorId(id);
            categoria.ifPresent(c -> model.addAttribute("categoria", c));
            model.addAttribute("error", e.getMessage());
            return "admin/categorias/eliminar";
        }
    }
}
