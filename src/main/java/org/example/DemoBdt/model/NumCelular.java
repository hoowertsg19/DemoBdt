package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "num_celular")
@Getter
@Setter
public class NumCelular extends ID {

    @Column(name = "numero_de_contacto", length = 15)
    @Required
    @Stereotype("TELEFONO")
    @DisplaySize(15) // Asumiendo que quieres un tamaño de 15 dígitos como máximo para los números de teléfono.
    private String numeroDeContacto;

}
