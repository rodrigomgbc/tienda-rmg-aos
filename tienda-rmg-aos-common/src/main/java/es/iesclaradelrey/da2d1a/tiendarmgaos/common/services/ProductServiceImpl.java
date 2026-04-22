package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements IProductService {

    @Override
    public Category guardar(Product product) {
        return null;
    }

    @Override
    public Optional<Product> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Product> buscarTodos() {
        return List.of();
    }

    @Override
    public void eliminarPorId(Long id) {

    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
