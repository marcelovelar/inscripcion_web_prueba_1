package com.inscripcionweb.persistance.repository;

import com.inscripcionweb.persistance.entity.UserEntity;
import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    Optional<UserEntity> findByIdPersona(String username);
}
