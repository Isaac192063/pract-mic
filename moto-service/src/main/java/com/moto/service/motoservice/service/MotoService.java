package com.moto.service.motoservice.service;

import com.moto.service.motoservice.model.Moto;
import com.moto.service.motoservice.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getmotoAll(){
        return  motoRepository.findAll();
    }

    public Moto getmotoById(long id){
        return motoRepository.findById(id).orElse(null);
    }

    public Moto savemoto(Moto usuario){
        return motoRepository.save(usuario);
    }

    public List<Moto> byUsuarioId(int idUsuario){
        return motoRepository.findByUsuarioId(idUsuario);
    }
}
