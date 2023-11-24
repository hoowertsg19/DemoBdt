package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombres, apellidos")
})
public class Estudiante extends ID {

    @Column(name = "nombres", length = 100, nullable = false)
    @Required
    @Size(min = 2, max = 100)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    @Required
    @Size(min = 2, max = 100)
    private String apellidos;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    @Required
    private Sexo sexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ciudad_origen")
    @DescriptionsList(descriptionProperties="nombreCiudad")
    private CiudadOrigen ciudadOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_num_celular")
    private NumCelular numCelular;


    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;


    @Column(name = "correo_electronico", length = 100)
    @Email
    @Required
    private String correoElectronico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_carrera")
    @DescriptionsList(descriptionProperties="nombreCarrera")
    private Carrera carrera;

    @Column(name = "ano_graduacion_esperado")
    private int anoGraduacionEsperado;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ListProperties("idioma, nivel")
    private List<EstudianteIdiomas> idiomasEstudiante;

}
