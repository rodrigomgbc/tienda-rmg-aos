package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;

import java.util.Collection;
import java.util.Optional;

// El Service es la capa que estaría entre el Controller y el Repository.
// Aquí iría la lógica de negocio (validaciones, cálculos, etc.).
// De momento solo "pasamos" las llamadas al repositorio, pero así ya queda
// preparado para cuando queramos meter reglas más chungas sin tocar el controller.
public interface ICategoriaService {

    Categoria guardar(Categoria category);
    Optional<Categoria> buscarPorId(Long id);
    Collection<Categoria> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);

}
