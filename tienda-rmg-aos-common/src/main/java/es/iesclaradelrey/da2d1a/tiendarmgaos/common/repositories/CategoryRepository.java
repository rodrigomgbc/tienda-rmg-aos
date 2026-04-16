package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends AbstractMapRepository<Category, Long>
    implements ICategoryRepository {

    @Override
    protected Long obtenerID(Category entidad) {
        return entidad.getId();
    }
}
