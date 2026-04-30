package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/productos")
public class ProductoAdminController {

    private final IProductoService productoService;

    public ProductoAdminController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public String redirigir() {
        return "redirect:/admin/productos";
    }

    @GetMapping("")
    public String listar(Model model) {
        model.addAttribute("productos", productoService.buscarTodos());
        return "admin/productos/lista";
    }
}
