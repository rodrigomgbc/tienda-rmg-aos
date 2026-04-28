package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;

import java.util.Collection;
import java.util.Optional;

// El Service es la capa que estaria entre el Controller y el Repository.
// Aqui iria la logica de negocio (validaciones, calculos, etc.).
// De momento solo "pasamos" las llamadas al repositorio, pero asi ya queda
// preparado para cuando queramos meter reglas mas chungas sin tocar el controller.
public interface IMarcaService {

    Marca guardar(Marca marca);
    Optional<Marca> buscarPorId(Long id);
    Collection<Marca> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);

}
