package com.alura.ForoHub.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topicoRepository;

    public TopicoModel registrarTopico(TopicoModel request){
        return topicoRepository.save(request);
    }

    public ArrayList<TopicoModel> listarTopicos(){
        return (ArrayList<TopicoModel>) topicoRepository.findAll();
    }

    public Optional<TopicoModel> obtenerTopico(Long id){
        return topicoRepository.findById(id);
    }

    public TopicoModel actualizarTopico(Long id, TopicoModel request){
        TopicoModel topicoModel = topicoRepository.findById(id).get();
        topicoModel.setUser_id(request.getUser_id());
        topicoModel.setCurso(request.getCurso());
        topicoModel.setTitulo(request.getTitulo());
        topicoModel.setMensaje(request.getMensaje());
        topicoRepository.save(topicoModel);
        return topicoModel;
    }

    public Boolean eliminarTopico(Long id){
        try{
            topicoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
