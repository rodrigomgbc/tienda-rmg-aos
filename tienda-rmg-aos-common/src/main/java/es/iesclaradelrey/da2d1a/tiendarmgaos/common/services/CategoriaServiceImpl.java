package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.ICategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

// @Service -> otra anotación para que Spring sepa que esto es un bean.
// Es igual que @Repository pero semánticamente marca "capa de servicio".
@Service
public class CategoriaServiceImpl implements ICategoriaService{

    // final -> una vez asignado en el constructor ya no se puede cambiar.
    // Es buena práctica para dependencias inyectadas.
    private final ICategoriaRepository categoriaRepository;

    // Inyección de dependencias mediante el constructor:
    // Spring ve que necesitamos un ICategoriaRepository y nos mete el bean
    // (CategoriaRepository) automáticamente. No hacemos new en ningún lado.
    public CategoriaServiceImpl(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // A partir de aquí, los métodos simplemente delegan en el repositorio.
    // Cuando haya lógica de negocio (validar nombres, reglas, etc) se mete aquí.
    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Collection<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return categoriaRepository.existsById(id);
    }

}
