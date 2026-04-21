package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Category;
import org.springframework.stereotype.Repository;

// @Repository -> le dice a Spring que esto es un "bean" que puede inyectar
// donde haga falta (por ejemplo en el Service). Sin esta anotación, Spring
// no lo encontraría aunque existiera la clase.
@Repository
public class CategoryRepository extends AbstractMapRepository<Category, Long>
    implements ICategoryRepository {

    // Como la clase abstracta no sabe cómo sacar el id de una Category,
    // aquí se lo decimos: el id es lo que devuelve getId().
    @Override
    protected Long obtenerID(Category entidad) {
        return entidad.getId();
    }
}
