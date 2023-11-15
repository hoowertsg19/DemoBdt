package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "estudiante_idiomas")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombres, apellidos, sexo, fechaNacimiento, correoElectronico") // Ajusta los campos según tu modelo
})
public class EstudianteIdiomas extends ID {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    @ReferenceView("Simple") // Utiliza una vista sencilla para el estudiante
    @Required
    private Estudiante estudiante;

    @Column(name = "idioma", length = 50)
    @Required
    @DisplaySize(20) // Tamaño visual en la UI
    private String idioma;

    @Column(name = "nivel", length = 50)
    @Required
    private String nivel;

    // Getters y setters generados por Lombok

    // Métodos adicionales si es necesario
}
