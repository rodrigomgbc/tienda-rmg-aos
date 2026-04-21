package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz específica para Category.
// Al extender IRepository<Category, Long> ya hereda guardar, buscarPorId, etc.
// Si algún día quisiéramos un método raro (ej: buscarPorNombre) lo meteríamos aquí.
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    // De momento no necesita métodos adicionales
    // Hereda todos lo métodos de IReposotory
}
