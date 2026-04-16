package es.iesclaradelrey.da2d1a.tiendarmgaos.web;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ICategoryService categoryService;

    public DataLoader(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        categoryService.guardar(new Category(1L, "Arábica", "Cafés de variedad arábca, reconocidos por su suavidad y complejidad aromática.", "arabica.jpg", true));
        categoryService.guardar(new Category(1L, "Robusta", "Cafés de variedad robusta, con mayor cuerpo y contenido en cafeína.", "robusta.jpg", true));
        categoryService.guardar(new Category(3L, "Tueste Claro", "Cafés con tueste claro, que preservan las notas florales y frutales del origen.", "tueste-claro.jpg", true));
        categoryService.guardar(new Category(4L, "Tueste Oscuro", "Cafés con tueste oscuro, con notas de chocolate, caramelo y mayor amargor.", null, true));

    }
}
