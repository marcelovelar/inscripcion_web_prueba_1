package com.inscripcionweb.service;

import com.inscripcionweb.persistance.entity.DeudaPendiente;
import com.inscripcionweb.persistance.repository.DeudaPendienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeudaPendienteService {

    private final DeudaPendienteRepository deudaPendienteRepository;

    @Autowired
    public DeudaPendienteService(DeudaPendienteRepository deudaPendienteRepository) {
        this.deudaPendienteRepository = deudaPendienteRepository;
    }

    public List<DeudaPendiente> getAll(){
        return this.deudaPendienteRepository.findAll();
    }
}
