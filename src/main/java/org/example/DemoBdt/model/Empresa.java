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
        @View(name = "Simple", members = "nombreEmpresa") // Ajusta los campos según lo que desees mostrar
})
public class Empresa extends ID {

    @Column(name = "nombre_empresa", length = 100, nullable = false)
    @Required
    @DisplaySize(30) // Controla el tamaño de la visualización del campo en la UI
    private String nombreEmpresa;

    @Column(name = "perfil_empresa", length = 500)
    @Stereotype("MEMO") // Permite introducir texto largo con saltos de línea
    private String perfilEmpresa;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

    @Column(name = "pagina_web", length = 255)
    @Stereotype("URL") // Valida que el texto introducido sea una URL
    private String paginaWeb;

    @Column(name = "telefono", length = 50)
    @Stereotype("TELEFONO") // Utiliza el estereotipo de teléfono para dar formato correcto
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    @Stereotype("EMAIL") // Valida que el texto introducido sea un correo electrónico
    private String correoElectronico;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ListProperties("titulo, descripcion, fechaPublicacion") // Ajusta según las propiedades de tu entidad VacantePasantia
    private Collection<VacantePasantia> vacantesPasantias;

    // Getters y setters generados por Lombok

    // Métodos adicionales si es necesario
}
