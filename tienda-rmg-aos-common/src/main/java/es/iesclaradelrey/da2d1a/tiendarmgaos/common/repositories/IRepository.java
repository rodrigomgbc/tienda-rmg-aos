package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import java.util.Collection;
import java.util.Optional;

/*
   * T y id son tipos genericos. Se usan para que esta interfaz sirva para cualquier tipo de entidad y cualquier tipo
   * de identificador. T representa la entidad con la que se va a trabajar e ID representa el tipo de dato de la clave
   * primaria de esa entidad.
 */
// Esta interfaz es el "contrato" que debe cumplir cualquier repositorio.
// Como usa genéricos (T, ID) nos sirve para Category, Producto, o lo que sea.
// Así no tenemos que duplicar la misma lógica para cada entidad.
public interface IRepository<T, ID> {

    T guardar(T entidad);                    // crea o actualiza
    Optional<T> buscarPorId(ID id);          // Optional por si no existe -> evita NullPointer
    Collection<T> buscarTodos();             // devuelve todas
    void eliminarPorId(ID id);               // borra por id
    boolean existePorId(ID id);              // true si hay una entidad con ese id

}
