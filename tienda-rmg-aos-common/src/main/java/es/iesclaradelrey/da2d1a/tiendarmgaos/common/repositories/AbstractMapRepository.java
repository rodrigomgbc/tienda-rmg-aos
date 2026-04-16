package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import java.util.*;

public abstract class AbstractMapRepository<T, ID> implements IRepository<T, ID> {

    // El Map donde se las entidades van a ser almacenadas
    // La clave es el ID y el valor es la entidad
    private Map<ID, T> almacenamiento = new HashMap<>();

    @Override
    public T guardar(T entidad) {
        almacenamiento.put(obtenerID(entidad), entidad);
        return entidad;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public Collection<T> buscarTodos() {
        return almacenamiento.values();
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
    protected abstract ID obtenerID(T entidad);
}
