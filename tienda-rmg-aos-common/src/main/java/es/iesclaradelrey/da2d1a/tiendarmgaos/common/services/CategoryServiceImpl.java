package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

// @Service -> otra anotación para que Spring sepa que esto es un bean.
// Es igual que @Repository pero semánticamente marca "capa de servicio".
@Service
public class CategoryServiceImpl implements ICategoryService{

    // final -> una vez asignado en el constructor ya no se puede cambiar.
    // Es buena práctica para dependencias inyectadas.
    private final ICategoryRepository categoryRepository;

    // Inyección de dependencias mediante el constructor:
    // Spring ve que necesitamos un ICategoryRepository y nos mete el bean
    // (CategoryRepository) automáticamente. No hacemos new en ningún lado.
    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // A partir de aquí, los métodos simplemente delegan en el repositorio.
    // Cuando haya lógica de negocio (validar nombres, reglas, etc) se mete aquí.
    @Override
    public Category guardar(Category categoria) {
        return categoryRepository.save(categoria);
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Collection<Category> buscarTodos() {
        return categoryRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return categoryRepository.existsById(id);
    }

}
