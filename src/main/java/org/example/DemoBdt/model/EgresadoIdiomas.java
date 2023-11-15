package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "idioma, nivel") // Define los miembros que quieres mostrar en la vista "Simple"
})
public class EgresadoIdiomas extends ID {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_egresado", referencedColumnName = "id")
    private Egresado egresado;

    @Column(name = "idioma", length = 50)
    private String idioma;

    @Column(name = "nivel", length = 50)
    private String nivel;

    // Getters y setters generados por Lombok
}
