package com.inscripcionweb.persistance.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
@Getter
@Setter
@NoArgsConstructor
public class UserRoleEntity {

    @Id
    @Column(name = "id_user",nullable = false)
    private Integer idUser;

    @Id
    @Column(nullable = false, length = 20)
    private String role;


    @Column (name = "granted_date", nullable = false, columnDefinition = "timestamp")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "id_User", referencedColumnName = "id_User", insertable = false, updatable = false)
    private UserEntity user;
}
