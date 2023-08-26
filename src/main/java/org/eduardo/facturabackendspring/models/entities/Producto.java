package org.eduardo.facturabackendspring.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_producto")
    @NotNull
    private String nombre;

    @Positive(message = "El valor no puede ser negativo")
    @Column(name = "precio_unitario")
    @NotEmpty
    private Float precioUnit;
}
