package org.workshop.proyecto1.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.proyecto1.entitys.Usuario;
import org.workshop.proyecto1.modelos.Carro;
import org.workshop.proyecto1.modelos.Moto;
import org.workshop.proyecto1.servicio.UsuarioService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUser(){
        List<Usuario> users = usuarioService.getUsuarioAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable int id){
        Usuario usuario = usuarioService.getUsuarioById(id);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }
    @PostMapping
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }

    @GetMapping("/carro/{usuarioId}")
    public ResponseEntity<List<Carro>> getCarros(@PathVariable("usuarioId") int id){
        Usuario usuario = usuarioService.getUsuarioById(id);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.getCarros(id));
    }

    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId") int id){
        Usuario usuario = usuarioService.getUsuarioById(id);

        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.getMotos(id));
    }

    @PostMapping("/carro/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int id, @RequestBody Carro carro){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveCarro(carro, id));
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto,@PathVariable("usuarioId") int id){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveMoto(moto, id));
    }

    @GetMapping("/vehiculo/{usuarioId}")
    public ResponseEntity<Map<String, Object>> getuserandVehiculos(@PathVariable("usuarioId") int id ){
        return ResponseEntity.ok(usuarioService.getUsersAndVehicles(id));
    }
}

