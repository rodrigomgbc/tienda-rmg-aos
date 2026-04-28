package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Clase que representa una Marca de café (la marca a la que pertenece cada producto).
// Usamos el mismo patrón que Categoria:
//   @Data            -> getters, setters, toString, equals y hashCode
//   @NoArgsConstructor  -> constructor vacío (lo necesita JPA al instanciar desde la BD)
//   @AllArgsConstructor -> constructor con todos los campos (cómodo al crear objetos)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // clave única de cada marca

    @Column(length = 100, nullable = false, unique = true)
    private String nombre;          // ej: "Illy", "Saimaza"

    @Column(length = 2000)
    private String descripcion;     // texto descriptivo

    @Column(length = 500)
    private String imagen;          // ruta del logo

    private Boolean activo;         // por si en el futuro queremos ocultarla sin borrar

    // no ponemos aqui la relacion @OneToMany con Producto todavia.
    // Esa la añadimos en el paso 2 junto con el @ManyToOne del lado Producto.
    // Si la pones ahora a medias, Hibernate no arranca y nos volvemos locos.
}