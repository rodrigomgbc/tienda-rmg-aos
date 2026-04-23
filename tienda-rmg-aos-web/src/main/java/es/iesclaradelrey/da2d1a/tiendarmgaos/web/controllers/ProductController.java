package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import org.springframework.ui.Model;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("productos", productService.buscarTodos());
        return "productos/list";
    }
}
