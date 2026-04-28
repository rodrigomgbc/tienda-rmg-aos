package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13)
    private String codigoEan;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 4000)
    private String descripcion;

    @Column(length = 500)
    private String imagen;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer descuento;

    // Relacion Producto -> Marca (muchos a uno).
    //   optional = false       -> el producto SIEMPRE tiene marca (el PDF lo exige).
    //   @JoinColumn nullable=false  -> la columna FK 'marca_id' tampoco admite null.
    // Hibernate creara una columna marca_id en la tabla productos.
    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    // Relacion Producto <-> Categoria (muchos a muchos).
    //   @JoinTable define la tabla pivote 'productos_categorias' con dos FK:
    //     producto_id  -> productos.id
    //     categoria_id -> categorias.id
    // Excluimos la coleccion del toString/equals/hashCode para evitar bucles infinitos.
    @ManyToMany
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Categoria> categorias = new HashSet<>();
}
