package com.alura.ForoHub.usuario;

public record UsuarioDTO(
        String nombre,
        String username,
        String password,
        Boolean habilitar
) {
}
