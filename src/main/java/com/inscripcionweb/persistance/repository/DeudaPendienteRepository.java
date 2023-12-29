package com.inscripcionweb.persistance.repository;

import com.inscripcionweb.persistance.entity.DeudaPendiente;
import org.springframework.data.repository.CrudRepository;
//CAMBIAR A LISTCRUDREPOSITORY SI USAMOS LA VERSION 3.0
//import org.springframework.data.repository.ListCrudRepository;

public interface DeudaPendienteRepository extends CrudRepository<DeudaPendiente, Integer> {

}
