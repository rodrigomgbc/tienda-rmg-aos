package es.iesclaradelrey.da2d1a.tiendarmgaos.common.services;

import es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories.IMarcaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

// @Service -> otra anotacion para que Spring sepa que esto es un bean.
// Es igual que @Repository pero semanticamente marca "capa de servicio".
@Service
public class MarcaServiceImpl implements IMarcaService {

    // final -> una vez asignado en el constructor ya no se puede cambiar.
    // Es buena practica para dependencias inyectadas.
    private final IMarcaRepository marcaRepository;

    // Inyeccion de dependencias mediante el constructor:
    // Spring ve que necesitamos un IMarcaRepository y nos mete el bean
    // automaticamente. No hacemos new en ningun lado.
    public MarcaServiceImpl(IMarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    // A partir de aqui, los metodos simplemente delegan en el repositorio.
    // Cuando haya logica de negocio (validar nombres, reglas, etc) se mete aqui.
    @Override
    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Optional<Marca> buscarPorId(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Collection<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return marcaRepository.existsById(id);
    }

}
