package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IProductoService;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.utils.SlugUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// @RequestMapping("/productos") hace que TODAS las rutas de este controller
// empiecen por /productos, asi no tenemos que repetirlo en cada @GetMapping.
@Controller
@RequestMapping("/productos")
public class ProductoController {

    // Inyectamos el service para poder pedirle los productos.
    // El controller NUNCA habla directamente con el repositorio.
    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    // Ruta /productos -> lista todos los productos.
    // Ademas preparamos un mapa id -> slug para construir URLs "bonitas"
    // del tipo /productos/5/cafe-arabica-premium desde la plantilla.
    @GetMapping({"", "/"})
    public String listar(Model model) {
        Collection<Producto> productos = productoService.buscarTodos();
        Map<Long, String> slugs = new HashMap<>();
        for (Producto p : productos) {
            slugs.put(p.getId(), SlugUtils.toSlug(p.getNombre()));
        }
        model.addAttribute("productos", productos);
        model.addAttribute("slugs", slugs);
        return "productos/lista";   // -> templates/productos/lista.html
    }

    // Aceptamos dos formatos:
    //   /productos/{id}             -> funciona igualmente, sin slug
    //   /productos/{id}/{slug}      -> URL "bonita" que mostramos al usuario
    // El slug es solo informativo: lo que cuenta para buscar es el id.
    @GetMapping({"/{id}", "/{id}/{slug}"})
    public String detalle(@PathVariable Long id,
                          @PathVariable(required = false) String slug,
                          Model model) {
        Optional<Producto> producto = productoService.buscarPorId(id);
        // Si no existe el producto, redirigimos al listado para no romper.
        if (producto.isEmpty()) {
            return "redirect:/productos";
        }
        model.addAttribute("producto", producto.get());
        return "productos/detalle";   // -> templates/productos/detalle.html
    }
}
