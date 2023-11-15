package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "otros_estudios")
@Getter
@Setter
public class OtrosEstudios extends ID {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_egresado", referencedColumnName = "id")
    @ReferenceView("Simple") // Utiliza una vista sencilla para el egresado
    @Required
    private Egresado egresado;

    @Column(name = "institucion", length = 100)
    @Required
    private String institucion;

    @Column(name = "curso", length = 100)
    @Required
    private String curso;

    @Column(name = "referencia", length = 255)
    @Stereotype("MEMO")
    private String referencia; // Un campo adicional para una descripción o referencia sobre el curso


}
