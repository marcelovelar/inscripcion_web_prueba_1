package com.inscripcionweb.persistance.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user",nullable = false)
    private Integer idUser;

    @Column(nullable = false, length = 20)
    private String idPersona;

    @Column(nullable = false, length = 200)
    private String apellido;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(nullable = false, columnDefinition = "smallint")
    private Boolean locked;

    @Column(nullable = false, columnDefinition = "smallint")
    private Boolean disabled;

    @Column(length = 300)
    private String descripcion;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles;

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUser=" + idUser +
                ", idPersona='" + idPersona + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", locked=" + locked +
                ", disabled=" + disabled +
                ", descripcion='" + descripcion + '\'' +
                ", roles=" + roles +
                '}';
    }
}
