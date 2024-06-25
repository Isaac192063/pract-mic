package org.workshop.primerpcarroser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workshop.primerpcarroser.model.Carro;
import org.workshop.primerpcarroser.repository.CarroRepository;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getcarroAll(){
        return  carroRepository.findAll();
    }

    public Carro getcarroById(long id){
        return carroRepository.findById(id).orElse(null);
    }

    public Carro savecarro(Carro usuario){
        return carroRepository.save(usuario);
    }

    public List<Carro> byUsuarioId(int idUsuario){
        return carroRepository.findCarroByUsuarioId(idUsuario);
    }

}
