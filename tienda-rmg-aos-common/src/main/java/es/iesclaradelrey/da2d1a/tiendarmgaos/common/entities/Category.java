package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;


import jakarta.persistence.*;
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
@Table(name = "categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // clave única de cada categoría
    @Column(length = 100, nullable = false, unique = true)
    private String nombre;          // ej: "Arábica"
    @Column(length = 2000)
    private String descripcion;     // texto que describe la categoría
    @Column(length = 500)
    private String imagen;          // ruta de la imagen (puede ser null si no hay)
    private Boolean activo;         // Para poder ocultar categorias sin borrar contenido
}