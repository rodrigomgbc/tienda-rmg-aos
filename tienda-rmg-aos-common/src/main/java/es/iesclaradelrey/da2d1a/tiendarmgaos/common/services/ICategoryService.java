package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;

import java.util.Collection;
import java.util.Optional;

// El Service es la capa que estaría entre el Controller y el Repository.
// Aquí iría la lógica de negocio (validaciones, cálculos, etc.).
// De momento solo "pasamos" las llamadas al repositorio, pero así ya queda
// preparado para cuando queramos meter reglas más chungas sin tocar el controller.
public interface ICategoryService {

    Category guardar(Category category);
    Optional<Category> buscarPorId(Long id);
    Collection<Category> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);

}
