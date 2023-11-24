package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombreEmpresa, ubicacion, perfilEmpresa, paginaWeb, telefono, correoElectronico, vacantesPasantias")
})
public class Empresa extends ID {

    @Column(name = "nombre_empresa", length = 100, nullable = false)
    @Required
    @DisplaySize(30)
    private String nombreEmpresa;

    @Column(name = "perfil_empresa", length = 500)
    @Stereotype("MEMO")
    private String perfilEmpresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "ubicacion")
    @Required
    private Ubicacion ubicacion; // Enum para la ubicación

    @Column(name = "pagina_web", length = 255)
    @Stereotype("URL")
    private String paginaWeb;

    @Column(name = "telefono", length = 50)
    @Stereotype("TELEFONO")
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    @Stereotype("EMAIL")
    private String correoElectronico;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ListProperties("titulo, descripcion, fechaPublicacion")
    private Collection<VacantePasantia> vacantesPasantias;

}
