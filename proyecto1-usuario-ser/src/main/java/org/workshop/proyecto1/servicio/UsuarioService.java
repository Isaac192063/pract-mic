package org.workshop.proyecto1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.workshop.proyecto1.entitys.Usuario;
import org.workshop.proyecto1.feignclients.CarroFeignClient;
import org.workshop.proyecto1.feignclients.MotoFeignClient;
import org.workshop.proyecto1.modelos.Carro;
import org.workshop.proyecto1.modelos.Moto;
import org.workshop.proyecto1.repositorio.UsuarioRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RestTemplate restTemplate;

    // clientes de feign client
    @Autowired
    private CarroFeignClient carroFeignClient;

    @Autowired
    private MotoFeignClient motoFeignClient;


    public List<Usuario> getUsuarioAll(){
        return  usuarioRepositorio.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public List<Carro> getCarros(int usuarioId){
        return restTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioId, List.class);
    }

    public List<Moto> getMotos(int usuarioId){
        return restTemplate.getForObject("http://localhost:8083/moto/usuario/"+usuarioId, List.class);
    }
    // feign client
    public Carro saveCarro(Carro carro, int idUsuario){
        carro.setUsuarioId(idUsuario);
        return  carroFeignClient.save(carro);
    }

    public Moto saveMoto(Moto moto, int idUsuario){
        moto.setUsuarioId(idUsuario);
        return motoFeignClient.saveMoto(moto);
    }

    public Map<String, Object> getUsersAndVehicles(int id){
        Map<String, Object> response = new HashMap<>();

        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);

        if(usuario == null){
            response.put("Mensaje", "No se encontro el usuario");
            return  response;
        }

        List<Moto> motos = motoFeignClient.getAllMotos(id);

        if (motos.isEmpty()){
            response.put("motos", "El usuario no tiene motos");
        }else{
            response.put("moto", motos);
        }

        List<Carro> carros = carroFeignClient.getAllCarros(id);

        if(carros.isEmpty()){
            response.put("carros", "El uaurio no tiene carros");
        }else{
            response.put("carros", carros);
        }
        return  response;
    }

}
