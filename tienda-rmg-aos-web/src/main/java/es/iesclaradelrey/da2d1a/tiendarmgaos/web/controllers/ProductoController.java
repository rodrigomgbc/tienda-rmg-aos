package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.utils.SlugUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@GetMapping({"", "/"})
public String listar(Model model) {
    Collection<Producto> productos = productoService.buscarTodos();
    Map<Long, String> slugs = new HashMap<>();
    for (Producto p : productos) {
        slugs.put(p.getId(), SlugUtils.toSlug(p.getNombre()));
    }
    model.addAttribute("productos", productos);
    model.addAttribute("slugs", slugs);
    return "productos/lista";
}

@GetMapping({"/{id}/{slug}", "/{id}"})
public String detalle(@PathVariable Long id,
                      @PathVariable(required = false) String slug,
                      Model model) {
    Optional<Producto> producto = productoService.buscarPorId(id);
    if (producto.isEmpty()) {
        return "redirect:/productos";
    }
    model.addAttribute("producto", producto.get());
    return "productos/detalle";
}