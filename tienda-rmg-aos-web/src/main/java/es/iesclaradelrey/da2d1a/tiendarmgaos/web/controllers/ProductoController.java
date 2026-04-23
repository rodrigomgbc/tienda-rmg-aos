package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import org.springframework.ui.Model;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("productos", productoService.buscarTodos());
        return "productos/lista";
    }
}
