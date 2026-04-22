package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
