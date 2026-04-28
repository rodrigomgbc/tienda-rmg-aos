package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz especifica para Marca.
// Al extender JpaRepository<Marca, Long> ya hereda guardar, buscarPorId, etc.
// Si algun dia quisieramos un metodo raro (ej: buscarPorNombre) lo meteriamos aqui.
public interface IMarcaRepository extends JpaRepository<Marca, Long> {
    // De momento no necesita metodos adicionales
    // Hereda todos los metodos de JpaRepository
}
