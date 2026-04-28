package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

// Clase que representa una Categoria de cafe en nuestra tienda.
// Las anotaciones de Lombok nos ahorran escribir a mano:
//   @Data            -> getters, setters, toString, equals y hashCode
//   @NoArgsConstructor  -> constructor vacio (necesario para frameworks)
//   @AllArgsConstructor -> constructor con todos los campos (util al crear objetos)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // clave unica de cada categoria
    @Column(length = 100, nullable = false, unique = true)
    private String nombre;          // ej: "Arabica"
    @Column(length = 2000)
    private String descripcion;     // texto que describe la categoria
    @Column(length = 500)
    private String imagen;          // ruta de la imagen (puede ser null si no hay)
    private Boolean activo;         // Para poder ocultar categorias sin borrar contenido

    // Lado inverso de la relacion Producto<->Categoria.
    //   mappedBy = "categorias"  -> apunta al campo 'categorias' de la clase Producto.
    //   No se crea otra tabla pivote, ya esta definida en el otro lado.
    //   Por defecto es LAZY.
    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Producto> productos = new HashSet<>();
}
