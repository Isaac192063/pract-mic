package org.workshop.proyecto1.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.workshop.proyecto1.modelos.Moto;

import java.util.List;

@FeignClient(name = "moto-service", url = "http://localhost:8083")
public interface MotoFeignClient {
    @PostMapping("/moto")
    Moto saveMoto(@RequestBody Moto moto);

    @GetMapping("/moto/usuario/{usuarioId}")
    List<Moto> getAllMotos(@PathVariable("usuarioId") int usuarioId);
}
