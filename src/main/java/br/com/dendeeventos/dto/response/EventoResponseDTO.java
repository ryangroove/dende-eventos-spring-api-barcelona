package br.com.dendeeventos.dto.response;

import java.time.LocalDate;

public record EventoResponseDTO(
        Long id,
        String nome,
        String descricao,
        LocalDate dataEvento
) {
}