package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;

import java.util.Collection;
import java.util.Optional;

public interface IProductoService {
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    Collection<Producto> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}
