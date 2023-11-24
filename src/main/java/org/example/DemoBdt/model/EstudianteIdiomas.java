package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "estudiante_idiomas")
@Getter
@Setter
public class EstudianteIdiomas extends ID {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    @ReferenceView("Simple")
    @Required
    private Estudiante estudiante;

    @Column(name = "idioma", length = 50)
    @Required
    @Enumerated(EnumType.STRING) // Usando Enum para definir una lista de idiomas
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

        private String descripcion;

        NivelIdioma(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    // Getters y setters
}
