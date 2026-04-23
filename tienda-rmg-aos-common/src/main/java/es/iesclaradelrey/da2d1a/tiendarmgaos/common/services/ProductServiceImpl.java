    package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Product;
    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.IProductRepository;
    import org.springframework.stereotype.Service;

    import java.util.Collection;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class ProductServiceImpl implements IProductService {

        private final IProductRepository productRepository;

        public ProductServiceImpl(IProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public Product guardar(Product product) {
            return productRepository.save(product);
        }

        @Override
        public Optional<Product> buscarPorId(Long id) {
            return productRepository.findById(id);
        }

        @Override
        public Collection<Product> buscarTodos() {
            return productRepository.findAll();
        }

        @Override
        public void eliminarPorId(Long id) {
            productRepository.deleteById(id);
        }

        @Override
        public boolean existePorId(Long id) {
            return productRepository.existsById(id);
        }
    }
