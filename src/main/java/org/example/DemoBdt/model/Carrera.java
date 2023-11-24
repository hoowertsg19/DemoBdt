package org.example.DemoBdt.model;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Carrera extends ID {

    @Column(name = "NombreCarrera", length = 50, nullable = false)
    @Required
    @DisplaySize(50)
    @Stereotype("NOMBRE")
    private String nombreCarrera;



    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    @ListProperties("nombres, apellidos, correoElectronico")
    private List<Estudiante> estudiantes;
}