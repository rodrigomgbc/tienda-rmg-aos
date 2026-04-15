package es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories;

public interface IRepository<T, ID> {

    T guardar(T entidad);

}
