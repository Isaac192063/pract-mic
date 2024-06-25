package org.workshop.proyecto1.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.workshop.proyecto1.modelos.Carro;

import java.util.List;

@FeignClient(name = "carro-service", url = "http://localhost:8082")
public interface CarroFeignClient {
    @PostMapping("/carro")
    Carro save(@RequestBody Carro carro);

    @GetMapping("/carro/usuario/{idUsuario}")
    List<Carro> getAllCarros(@PathVariable("idUsuario") int idUsuario);
}
