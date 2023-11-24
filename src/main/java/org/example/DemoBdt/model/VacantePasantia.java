package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacante_pasantia")
@Getter
@Setter
public class VacantePasantia extends ID {

    @Column(name = "titulo", length = 100)
    @Required
    private String titulo;

    @Column(name = "descripcion", length = 1000)
    @Stereotype("MEMO")
    private String descripcion;

    @Column(name = "nombre_puesto", length = 100)
    private String nombrePuesto;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "horarios", length = 255)
    private String horarios;

    @Column(name = "idiomas", length = 255)
    private String idiomas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ReferenceView("Simple")
    private Empresa empresa;


    @Column(name = "estado", length = 50)
    @Enumerated(EnumType.STRING)
    private EstadoVacante estado;


    @Column(name = "requisitos", length = 1000)
    @Stereotype("MEMO")
    private String requisitos;

}

enum EstadoVacante {
    ACTIVA,
    LLENA,
    CERRADA
}
