package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IMarcaService;
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

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final IMarcaService marcaService;

    public MarcaController(IMarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping({"/{id}", "/{id}/{slug}"})
    public String detalle(@PathVariable Long id,
                          @PathVariable(required = false) String slug,
                          Model model) {

        Optional<Marca> marcaOpt = marcaService.buscarPorId(id);
        if (marcaOpt.isEmpty()) {
            return "redirect:/productos";
        }

        Marca marca = marcaOpt.get();

        // Orden alfabético con Comparator funcional, no con JPA
        List<Producto> productosOrdenados = marca.getProductos()
                .stream()
                .sorted(Comparator.comparing(Producto::getNombre))
                .toList();

        Map<Long, String> slugs = new HashMap<>();
        for (Producto p : productosOrdenados) {
            slugs.put(p.getId(), SlugUtils.toSlug(p.getNombre()));
        }

        model.addAttribute("marca", marca);
        model.addAttribute("productos", productosOrdenados);
        model.addAttribute("slugs", slugs);

        return "marcas/detalle";
    }
}