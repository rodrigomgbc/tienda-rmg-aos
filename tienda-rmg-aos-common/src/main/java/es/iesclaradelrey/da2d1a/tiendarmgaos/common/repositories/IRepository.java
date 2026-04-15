package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import java.util.Collection;
import java.util.Optional;

/*
   * T y id son tipos genericos. Se usan para que esta interfaz sirva para cualquier tipo de entidad y cualquier tipo
   * de identificador. T representa la entidad con la que se va a trabajar e ID representa el tipo de dato de la clave
   * primaria de esa entidad.
 */
public interface IRepository<T, ID> {

    T guardar(T entidad);
    Optional<T> buscarPorId(ID id);
    Collection<T> buscarTodos();
    void eliminarPorId(ID id);
    boolean existePorId(ID id);

}
