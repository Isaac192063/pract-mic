package org.workshop.primerpcarroser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.primerpcarroser.model.Carro;
import org.workshop.primerpcarroser.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> getAllCarro(){
        List<Carro> carros = carroService.getcarroAll();
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable int id){
        Carro carro = carroService.getcarroById(id);

        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }
    @PostMapping
    public ResponseEntity<Carro> saveCarro(@RequestBody Carro carro){
        return  ResponseEntity.status(HttpStatus.CREATED).body(carroService.savecarro(carro));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Carro>> obtenerCarroPorUsuario(@PathVariable int id){
        List<Carro> carros = carroService.byUsuarioId(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
}
