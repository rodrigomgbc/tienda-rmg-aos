package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;

    // Inyección de dependencias mediante el constructor
    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category guardar(Category categoria) {
        return categoryRepository.guardar(categoria);
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return categoryRepository.buscarPorId(id);
    }

    @Override
    public Collection<Category> buscarTodos() {
        return categoryRepository.buscarTodos();
    }

    @Override
    public void eliminarPorId(Long id) {
        categoryRepository.eliminarPorId(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return categoryRepository.existePorId(id);
    }

}
