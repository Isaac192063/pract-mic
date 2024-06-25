package com.moto.service.motoservice.controller;

import com.moto.service.motoservice.model.Moto;
import com.moto.service.motoservice.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getAllMoto(){
        List<Moto> motos = motoService.getmotoAll();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable int id){
        Moto moto = motoService.getmotoById(id);

        if(moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }
    @PostMapping
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(motoService.savemoto(moto));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Moto>> obtenerMotoPorUsuario(@PathVariable int id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
