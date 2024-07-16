package com.alura.ForoHub.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<ArrayList<UsuarioModel>> listarUsuarios(){
        ArrayList<UsuarioModel> arrayList = (ArrayList<UsuarioModel>) this.usuarioService.listarUsuarios();
        return ResponseEntity.ok(arrayList);
    }
}
