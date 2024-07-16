package com.alura.ForoHub.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> listarUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
}
