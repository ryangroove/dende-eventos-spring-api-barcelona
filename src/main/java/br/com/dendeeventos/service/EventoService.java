package br.com.dendeeventos.service;

import br.com.dendeeventos.dto.request.EventoRequestDTO;
import br.com.dendeeventos.dto.response.EventoResponseDTO;
import br.com.dendeeventos.entity.Evento;
import br.com.dendeeventos.entity.Organizador;
import br.com.dendeeventos.entity.Usuario;
import br.com.dendeeventos.mapper.EventoMapper;
import br.com.dendeeventos.repository.EventoRepository;
import br.com.dendeeventos.repository.OrganizadorRepository;
import br.com.dendeeventos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final OrganizadorRepository organizadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final EventoMapper eventoMapper;

    public EventoService(
            EventoRepository eventoRepository,
            OrganizadorRepository organizadorRepository,
            UsuarioRepository usuarioRepository,
            EventoMapper eventoMapper) {

        this.eventoRepository = eventoRepository;
        this.organizadorRepository = organizadorRepository;
        this.usuarioRepository = usuarioRepository;
        this.eventoMapper = eventoMapper;
    }

    public EventoResponseDTO criar(EventoRequestDTO dto) {

        Organizador organizador =
                organizadorRepository.findById(dto.organizadorId())
                        .orElseThrow();

        List<Usuario> participantes =
                usuarioRepository.findAllById(dto.participantesIds());

        Evento evento = new Evento();

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setOrganizador(organizador);
        evento.setParticipantes(participantes);

        evento = eventoRepository.save(evento);

        return eventoMapper.toResponse(evento);
    }

    public List<EventoResponseDTO> listar() {

        return eventoRepository.findAll()
                .stream()
                .map(eventoMapper::toResponse)
                .toList();
    }

    public EventoResponseDTO buscarPorId(Long id) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow();

        return eventoMapper.toResponse(evento);
    }

    public EventoResponseDTO atualizar(
            Long id,
            EventoRequestDTO dto) {

        Evento evento =
                eventoRepository.findById(id)
                        .orElseThrow();

        Organizador organizador =
                organizadorRepository.findById(dto.organizadorId())
                        .orElseThrow();

        List<Usuario> participantes =
                usuarioRepository.findAllById(dto.participantesIds());

        evento.setNome(dto.nome());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setOrganizador(organizador);
        evento.setParticipantes(participantes);

        evento = eventoRepository.save(evento);

        return eventoMapper.toResponse(evento);
    }

    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}