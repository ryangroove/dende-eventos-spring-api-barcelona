package br.com.dendeeventos.mapper;

import br.com.dendeeventos.dto.response.EventoResponseDTO;
import br.com.dendeeventos.entity.Evento;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public EventoResponseDTO toResponse(
            Evento evento) {

        return new EventoResponseDTO(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getDataEvento()
        );
    }
}