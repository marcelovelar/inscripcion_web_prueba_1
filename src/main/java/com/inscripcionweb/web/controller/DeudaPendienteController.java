package com.inscripcionweb.web.controller;

import com.inscripcionweb.persistance.entity.DeudaPendiente;
import com.inscripcionweb.service.DeudaPendienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/morosos")
public class DeudaPendienteController {

    private final DeudaPendienteService deudaPendienteService;

    @Autowired
    public DeudaPendienteController(DeudaPendienteService deudaPendienteService) {
        this.deudaPendienteService = deudaPendienteService;
    }

    @GetMapping
    public ResponseEntity<List<DeudaPendiente>> getAll(){
        return ResponseEntity.ok(this.deudaPendienteService.getAll());
    }



}
