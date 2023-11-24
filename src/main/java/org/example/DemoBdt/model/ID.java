package org.example.DemoBdt.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class ID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 8)
    @Hidden
    private Long id;
}
