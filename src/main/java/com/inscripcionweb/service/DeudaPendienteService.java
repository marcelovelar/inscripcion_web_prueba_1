package com.inscripcionweb.service;

import com.inscripcionweb.persistance.entity.DeudaPendiente;
import com.inscripcionweb.persistance.repository.DeudaPendienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeudaPendienteService {

    private final DeudaPendienteRepository deudaPendienteRepository;

    @Autowired
    public DeudaPendienteService(DeudaPendienteRepository deudaPendienteRepository) {
        this.deudaPendienteRepository = deudaPendienteRepository;
    }

    public List<DeudaPendiente> getAll(){
        return (List<DeudaPendiente>) this.deudaPendienteRepository.findAll();
        //return this.deudaPendienteRepository.findAll();
    }

    public DeudaPendiente getByCedula(){
        return null;
    }
}
