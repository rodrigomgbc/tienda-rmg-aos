package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Clase que representa una Categoría de café en nuestra tienda.
// Las anotaciones de Lombok nos ahorran escribir a mano:
//   @Data            -> getters, setters, toString, equals y hashCode
//   @NoArgsConstructor  -> constructor vacío (necesario para frameworks)
//   @AllArgsConstructor -> constructor con todos los campos (útil al crear objetos)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;                // clave única de cada categoría
    private String nombre;          // ej: "Arábica"
    private String descripcion;     // texto que describe la categoría
    private String imagen;          // ruta de la imagen (puede ser null si no hay)
    private Boolean activo;         // Para poder ocultar categorias sin borrar contenido
}