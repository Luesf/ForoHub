package com.alura.ForoHub.security;

import com.alura.ForoHub.usuario.RolUsuario;
import com.alura.ForoHub.usuario.UsuarioModel;
import com.alura.ForoHub.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionService {
    private final AuthService authService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AutenticacionResponse registrar(RequestRegistro request){
        UsuarioModel usuario = UsuarioModel.builder()
                .nombre(request.getNombre())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .habilitar(true)
                .rol(RolUsuario.USER)
                .build();
        usuarioRepository.save(usuario);
        return AutenticacionResponse.builder().token(authService.getToken(usuario)).build();
    }

    public AutenticacionResponse login(RequestLogin request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = authService.getToken(user);
        return AutenticacionResponse.builder().token(token).build();
    }
}
