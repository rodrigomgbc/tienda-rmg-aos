package es.iesclaradelrey.da2d1a.tiendarmgaos.web.controllers;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoriaService;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IMarcaService;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/productos")
public class ProductoAdminController {

    private final IProductoService productoService;
    private final IMarcaService marcaService;
    private final ICategoriaService categoriaService;

    public ProductoAdminController(IProductoService productoService,
                                   IMarcaService marcaService,
                                   ICategoriaService categoriaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
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

    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("marcas", marcaService.buscarTodos());
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "admin/productos/formulario";
    }

    @PostMapping("/new")
    public String guardarNuevo(@ModelAttribute Producto producto,
                               @RequestParam(required = false) Long marcaId,
                               @RequestParam(required = false) List<Long> categoriasIds,
                               Model model) {
        try {
            if (marcaId != null) {
                marcaService.buscarPorId(marcaId).ifPresent(producto::setMarca);
            }
            if (categoriasIds != null) {
                Set<Categoria> cats = categoriasIds.stream()
                        .map(categoriaService::buscarPorId)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toSet());
                producto.setCategorias(cats);
            }
            productoService.guardar(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("marcas", marcaService.buscarTodos());
            model.addAttribute("categorias", categoriaService.buscarTodos());
            return "admin/productos/formulario";
        }
    }

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.buscarPorId(id);
        if (producto.isEmpty()) {
            return "redirect:/admin/productos";
        }
        model.addAttribute("producto", producto.get());
        model.addAttribute("marcas", marcaService.buscarTodos());
        model.addAttribute("categorias", categoriaService.buscarTodos());
        return "admin/productos/formulario";
    }

    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id,
                                 @ModelAttribute Producto producto,
                                 @RequestParam(required = false) Long marcaId,
                                 @RequestParam(required = false) List<Long> categoriasIds,
                                 Model model) {
        try {
            producto.setId(id);
            if (marcaId != null) {
                marcaService.buscarPorId(marcaId).ifPresent(producto::setMarca);
            }
            if (categoriasIds != null) {
                Set<Categoria> cats = categoriasIds.stream()
                        .map(categoriaService::buscarPorId)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toSet());
                producto.setCategorias(cats);
            } else {
                producto.setCategorias(new java.util.HashSet<>());
            }
            productoService.guardar(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("marcas", marcaService.buscarTodos());
            model.addAttribute("categorias", categoriaService.buscarTodos());
            return "admin/productos/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String formularioEliminar(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.buscarPorId(id);
        if (producto.isEmpty()) {
            return "redirect:/admin/productos";
        }
        model.addAttribute("producto", producto.get());
        return "admin/productos/eliminar";
    }

    @PostMapping("/{id}/delete")
    public String eliminar(@PathVariable Long id, Model model) {
        try {
            productoService.eliminarPorId(id);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            Optional<Producto> producto = productoService.buscarPorId(id);
            producto.ifPresent(p -> model.addAttribute("producto", p));
            model.addAttribute("error", e.getMessage());
            return "admin/productos/eliminar";
        }
    }
}