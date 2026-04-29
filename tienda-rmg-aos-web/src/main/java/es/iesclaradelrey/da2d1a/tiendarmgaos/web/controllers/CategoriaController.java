package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoriaService;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.utils.SlugUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// @RequestMapping("/categorias") hace que TODAS las rutas de este controller
// empiecen por /categorias, asi no tenemos que repetirlo en cada @GetMapping.
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "categorias/lista";
    }

    // Ruta /categorias/{id} -> detalle de una categoria concreta + productos asociados.
    // PDF 7 paso 8: los productos se obtienen por la propiedad de navegacion
    // (categoria.getProductos()) y se ordenan alfabeticamente con Comparator<T>
    // (NO con OrderBy de JPA - lo prohibe el enunciado).
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Categoria> categoriaOpt = categoriaService.buscarPorId(id);
        if (categoriaOpt.isEmpty()) {
            return "redirect:/categorias";
        }

        Categoria categoria = categoriaOpt.get();

        // Orden alfabetico con Comparator funcional, no con JPA (lo exige el PDF).
        List<Producto> productosOrdenados = categoria.getProductos()
                .stream()
                .sorted(Comparator.comparing(Producto::getNombre))
                .toList();

        // Mapa id -> slug para construir URLs "bonitas" del detalle de cada producto.
        Map<Long, String> slugs = new HashMap<>();
        for (Producto p : productosOrdenados) {
            slugs.put(p.getId(), SlugUtils.toSlug(p.getNombre()));
        }

        model.addAttribute("categoria", categoria);
        model.addAttribute("productos", productosOrdenados);
        model.addAttribute("slugs", slugs);
        return "categorias/detalle";
    }
}
