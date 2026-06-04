package br.com.dendeeventos.mapper;

import br.com.dendeeventos.dto.request.EventoRequestDTO;
import br.com.dendeeventos.dto.response.EventoResponseDTO;
import br.com.dendeeventos.entity.Evento;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public Evento toEntity(EventoRequestDTO dto) {

        Evento evento = new Evento();

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());

        return evento;
    }

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