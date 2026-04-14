package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Boolean activo;         //Para poder ocultar categorias sin borrar contenido
}
