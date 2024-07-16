package com.alura.ForoHub.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacion")
@RequiredArgsConstructor
public class AutenticacionController {
    private AutenticacionService autenticacionService;

    @PostMapping(value = "registrar")
    public ResponseEntity<AutenticacionResponse> registrar(@RequestBody RequestRegistro request){
        return ResponseEntity.ok(autenticacionService.registrar(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<AutenticacionResponse> login(@RequestBody RequestLogin request){
        return ResponseEntity.ok(autenticacionService.login(request));
    }
}
