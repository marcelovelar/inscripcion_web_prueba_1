package com.inscripcionweb.persistance.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.TypeAlias;

@Entity
@Table(name = "permanencia")
@Getter
@Setter
@NoArgsConstructor
public class Permanencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permanencia", nullable = false)
    private Integer idPermanencia;

    @Column(nullable = false,length = 15)
    private String cedula;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false,length = 60)
    private String apellido;

    @Column(nullable = false,length = 60)
    private String carrera;

}
