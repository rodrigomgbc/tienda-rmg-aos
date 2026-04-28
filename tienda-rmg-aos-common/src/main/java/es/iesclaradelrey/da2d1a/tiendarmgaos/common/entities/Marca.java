package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

// Clase que representa una Marca de cafe (la marca a la que pertenece cada producto).
// Usamos el mismo patron que Categoria:
//   @Data            -> getters, setters, toString, equals y hashCode
//   @NoArgsConstructor  -> constructor vacio (lo necesita JPA al instanciar desde la BD)
//   @AllArgsConstructor -> constructor con todos los campos (comodo al crear objetos)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // clave unica de cada marca

    @Column(length = 100, nullable = false, unique = true)
    private String nombre;          // ej: "Illy", "Saimaza"

    @Column(length = 2000)
    private String descripcion;     // texto descriptivo

    @Column(length = 500)
    private String imagen;          // ruta del logo

    private Boolean activo;         // por si en el futuro queremos ocultarla sin borrar

    // Lado inverso de la relacion Producto->Marca.
    //   mappedBy = "marca"  -> apunta al campo 'marca' de la clase Producto.
    //   No se crea columna en esta tabla; la FK vive en la tabla productos.
    //   Por defecto es LAZY, asi que solo se cargan los productos al pedirlos.
    // Excluimos la coleccion del toString/equals/hashCode para evitar bucles infinitos
    // (Producto.toString -> Marca.toString -> productos -> Producto.toString -> ...).
    @OneToMany(mappedBy = "marca")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Producto> productos = new HashSet<>();
}
