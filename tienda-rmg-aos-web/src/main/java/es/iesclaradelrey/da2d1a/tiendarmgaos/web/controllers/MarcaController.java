package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;


import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IMarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final IMarcaService marcaService;

    public MarcaController(IMarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping({"/{id}", "/{id}/{slug}"})
}
