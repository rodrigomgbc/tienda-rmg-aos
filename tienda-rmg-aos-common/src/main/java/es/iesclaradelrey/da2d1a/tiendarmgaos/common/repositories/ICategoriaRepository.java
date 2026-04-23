package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz específica para Categoria.
// Al extender IRepository<Categoria, Long> ya hereda guardar, buscarPorId, etc.
// Si algún día quisiéramos un método raro (ej: buscarPorNombre) lo meteríamos aquí.
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    // De momento no necesita métodos adicionales
    // Hereda todos lo métodos de IReposotory
}
