package org.eduardo.facturabackendspring.models.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_factura")
    private Long id;

    @Column(name = "direccion_envio")
    @Nullable
    private String dirEnv;

    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE_ID"))
    private Cliente cliente;
}
