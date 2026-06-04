package br.com.dendeeventos.service;

import br.com.dendeeventos.dto.request.EventoRequestDTO;
import br.com.dendeeventos.dto.response.EventoResponseDTO;
import br.com.dendeeventos.entity.Evento;
import br.com.dendeeventos.entity.Organizador;
import br.com.dendeeventos.entity.Usuario;
import br.com.dendeeventos.mapper.EventoMapper;
import br.com.dendeeventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final OrganizadorService organizadorService;
    private final UsuarioService usuarioService;
    private final EventoMapper eventoMapper;

    public EventoService(
            EventoRepository eventoRepository,
            OrganizadorService organizadorService,
            UsuarioService usuarioService,
            EventoMapper eventoMapper) {

        this.eventoRepository = eventoRepository;
        this.organizadorService = organizadorService;
        this.usuarioService = usuarioService;
        this.eventoMapper = eventoMapper;
    }

    public EventoResponseDTO criar(EventoRequestDTO dto) {

        Organizador organizador =
                organizadorService.buscarEntidadePorId(
                        dto.organizadorId()
                );

        List<Usuario> participantes =
                dto.participantesIds()
                        .stream()
                        .map(usuarioService::buscarEntidadePorId)
                        .toList();

        Evento evento =
                eventoMapper.toEntity(dto);

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
                .orElseThrow(() ->
                        new RuntimeException("Evento não encontrado"));

        return eventoMapper.toResponse(evento);
    }

    public EventoResponseDTO atualizar(
            Long id,
            EventoRequestDTO dto) {

        Evento evento =
                eventoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Evento não encontrado"));

        Organizador organizador =
                organizadorService.buscarEntidadePorId(
                        dto.organizadorId()
                );

        List<Usuario> participantes =
                dto.participantesIds()
                        .stream()
                        .map(usuarioService::buscarEntidadePorId)
                        .toList();

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