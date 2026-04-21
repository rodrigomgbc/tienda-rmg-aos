package es.iesclaradelrey.da2d1a.tiendarmgaos.web;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.services.ICategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Al implementar CommandLineRunner, el método run() se ejecuta automáticamente
// nada más arrancar Spring Boot. Lo usamos para meter datos de prueba en memoria
// (como si fuera un "seed" de BDD) porque aún no tenemos base de datos real.
@Component
public class DataLoader implements CommandLineRunner {

    private final ICategoryService categoryService;

    // Inyección por constructor (igual que en el service).
    public DataLoader(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Id = null para que no de error hibernate ya que el id se genera de manera automática
    @Override
    public void run(String... args) throws Exception {
        // Creamos unas cuantas categorías de café de ejemplo.
        // El parámetro null del penúltimo hueco es la "imagen" -> no tienen foto.
        categoryService.guardar(new Category(null, "Arábica", "Cafés de variedad arábica...", null, true));
        categoryService.guardar(new Category(null, "Robusta", "Cafés de variedad robusta...", null, true));
        categoryService.guardar(new Category(null, "Tueste Claro", "Cafés con tueste claro...", null, true));
        categoryService.guardar(new Category(null, "Tueste Oscuro", "Cafés con tueste oscuro...", null, true));

    }
}
