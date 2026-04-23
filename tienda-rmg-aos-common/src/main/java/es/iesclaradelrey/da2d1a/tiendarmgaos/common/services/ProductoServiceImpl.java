    package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Producto;
    import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.IProductoRepository;
    import org.springframework.stereotype.Service;

    import java.util.Collection;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class ProductoServiceImpl implements IProductoService {

        private final IProductoRepository productoRepository;

        public ProductoServiceImpl(IProductoRepository productoRepository) {
            this.productoRepository = productoRepository;
        }

        @Override
        public Producto guardar(Producto producto) {
            return productoRepository.save(producto);
        }

        @Override
        public Optional<Producto> buscarPorId(Long id) {
            return productoRepository.findById(id);
        }

        @Override
        public Collection<Producto> buscarTodos() {
            return productoRepository.findAll();
        }

        @Override
        public void eliminarPorId(Long id) {
            productoRepository.deleteById(id);
        }

        @Override
        public boolean existePorId(Long id) {
            return productoRepository.existsById(id);
        }
    }
