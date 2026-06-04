package br.com.dendeeventos.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record EventoRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "A data do evento é obrigatória")
        @FutureOrPresent(message = "A data do evento deve ser hoje ou futura")
        LocalDate dataEvento,

        @NotNull(message = "O organizador é obrigatório")
        Long organizadorId,

        @NotEmpty(message = "A lista de participantes não pode estar vazia")
        List<Long> participantesIds

) {
}