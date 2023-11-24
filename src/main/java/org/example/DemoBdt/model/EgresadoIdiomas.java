package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "egresado_idiomas")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "idioma, nivel")
})
public class EgresadoIdiomas extends ID {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_egresado", referencedColumnName = "id")
    private Egresado egresado;

    @Enumerated(EnumType.STRING)
    @Column(name = "idioma", length = 50)
    @Required
    private Idioma idioma;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", length = 50)
    @Required
    private NivelIdioma nivel;

    // Enum para los idiomas
    public enum Idioma {
        INGLES, MANDARIN, ESPANOL, FRANCES, ARABE, HINDI, BENGALI, PORTUGUES, RUSO, JAPONES
    }

    // Enum para los niveles de idioma
    public enum NivelIdioma {
        PRE_INTERMEDIO("A2-B1: Pre-intermedio"),
        INTERMEDIO("B1: Intermedio"),
        INTERMEDIO_ALTO("B2: Intermedio-Alto"),
        AVANZADO("C1-C2: Avanzado");

        private final String descripcion;

        NivelIdioma(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }
}
