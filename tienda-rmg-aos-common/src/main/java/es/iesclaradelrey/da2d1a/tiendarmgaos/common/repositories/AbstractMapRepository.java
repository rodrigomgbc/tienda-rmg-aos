package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import java.util.*;

// Clase abstracta: NO se puede instanciar directamente (new AbstractMapRepository...).
// Aquí metemos la lógica que es igual para todos los repositorios
// (guardar, buscar, borrar...) y así no la repetimos en cada uno.
// Hacemos como "base de datos en memoria" usando un HashMap.
public abstract class AbstractMapRepository<T, ID> implements IRepository<T, ID> {

    // El Map donde se las entidades van a ser almacenadas
    // La clave es el ID y el valor es la entidad
    private Map<ID, T> almacenamiento = new HashMap<>();

    @Override
    public T guardar(T entidad) {
        // put mete la entidad en el map usando su id como clave
        almacenamiento.put(obtenerID(entidad), entidad);
        return entidad;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        // Optional.ofNullable -> si es null devuelve un Optional vacío
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public Collection<T> buscarTodos() {
        return almacenamiento.values();   // todos los valores del map
    }

    @Override
    public void eliminarPorId(ID id) {
        almacenamiento.remove(id);
    }

    @Override
    public boolean existePorId(ID id) {
        return almacenamiento.containsKey(id);
    }

    // Método abstracto que cada repositorio concreto debe implementar
    // porque esta clase no sabe como obtener el ID de cada entidad
    // (no sabe si T es Category, Producto, etc. -> que lo diga el hijo).
    protected abstract ID obtenerID(T entidad);
}
