package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Product;

import java.util.Collection;
import java.util.Optional;

public interface IProductService {
    Product guardar(Product product);
    Optional<Product> buscarPorId(Long id);
    Collection<Product> buscarTodos();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}
