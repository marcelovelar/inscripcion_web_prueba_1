package com.inscripcionweb.persistance.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumno_pago_pendiente")
@Getter
@Setter
@NoArgsConstructor
public class DeudaPendiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno", nullable = false)
    private Integer idAlumno;

    @Column(nullable = false,length = 15)
    private String cedula;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false,length = 60)
    private String apellido;

    @Column(nullable = false,length = 200)
    private String motivo;

}
