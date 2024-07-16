package com.alura.ForoHub.topico;

public record TopicoDTO(
        Long user_id,
        String curso,
        String titulo,
        String mensaje,
        Boolean habilitar
) {
}
