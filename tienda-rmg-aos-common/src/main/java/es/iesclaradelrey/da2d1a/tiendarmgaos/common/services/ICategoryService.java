package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;

import java.util.Collection;
import java.util.Optional;

public interface ICategoryService {

    Category guardar(Category category);
    Optional<Category> buscarPorId(Long id);
    Collection<Category> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);

}
