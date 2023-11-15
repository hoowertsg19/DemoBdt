package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Table(name = "ciudad_origen")
@Getter
@Setter
public class CiudadOrigen extends ID {

    @Column(name = "nombre_ciudad", length = 100)
    @Required
    @DisplaySize(30) // Define el tamaño de visualización del campo en la interfaz de usuario
    private String nombreCiudad;

    @Column(name = "pais_origen", length = 100)
    @Required
    @DisplaySize(30) // Define el tamaño de visualización del campo en la interfaz de usuario
    private String paisOrigen;

}
