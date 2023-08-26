package org.eduardo.facturabackendspring.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String apellido;

    @Column(nullable = false, unique = true, length = 10)
    @NotEmpty
    @NotNull
    private String dui;

    @Column(name = "direccion")
    @NotNull
    private String dir;

    @Column(name = "telefono")
    private Integer tel;
    @Column(name = "correo")
    private String email;

    @OneToMany(
            mappedBy = "factura",
            fetch = FetchType.LAZY
    )
    private Set<Factura> facturas;
}