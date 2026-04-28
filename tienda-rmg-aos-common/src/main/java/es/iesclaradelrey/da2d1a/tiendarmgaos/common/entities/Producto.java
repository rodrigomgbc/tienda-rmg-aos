package es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(length = 50)
    private String marca;
    @Column(nullable = false, length = 4000)
    private String descripcion;
    @Column(length = 500)
    private String imagen;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Integer descuento;

}
