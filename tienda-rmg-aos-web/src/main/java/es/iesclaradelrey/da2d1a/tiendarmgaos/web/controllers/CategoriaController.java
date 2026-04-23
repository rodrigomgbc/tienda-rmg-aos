package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

// @RequestMapping("/categorias") hace que TODAS las rutas de este controller
// empiecen por /categorias, así no tenemos que repetirlo en cada @GetMapping.
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    // Inyectamos el service para poder pedirle las categorías.
    // El controller NUNCA habla directamente con el repositorio.
    private final ICategoriaService categoriaService;

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Ruta /categorias -> lista todas las categorías.
    // "Model" es como un saco donde metemos datos para la plantilla Thymeleaf.
    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "categorias/lista";   // -> templates/categorias/lista.html
    }

    // Ruta /categorias/{id} -> detalle de una categoría concreta.
    // @PathVariable coge lo que haya en {id} de la URL y lo pasa como parámetro.
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);
        // Si no existe la categoría, redirigimos al listado para no romper.
        if (categoria.isEmpty()) {
            return "redirect:/categorias";
        }
        model.addAttribute("categoria",categoria.get());
        return "categorias/detalle";   // -> templates/categorias/detalle.html
    }
}
