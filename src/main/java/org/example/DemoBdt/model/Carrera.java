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
    @DisplaySize(50) // Define el tamaño del campo en la interfaz de usuario
    @Stereotype("NOMBRE") // Establece un estereotipo de OpenXAVA para aplicar estilos predefinidos
    private String nombreCarrera;


    // Para mejorar la experiencia de usuario, podrías añadir una lista de estudiantes asociados a la carrera
    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    @ListProperties("nombres, apellidos, correoElectronico") // Solo como ejemplo, ajusta según tus entidades
    private List<Estudiante> estudiantes; // Una lista de estudiantes que están cursando esta carrera
}