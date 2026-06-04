package br.com.dendeeventos.controller;

import br.com.dendeeventos.dto.request.EventoRequestDTO;
import br.com.dendeeventos.dto.response.EventoResponseDTO;
import br.com.dendeeventos.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService service;

    public EventoController(
            EventoService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> criar(
            @Valid @RequestBody EventoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> listar() {

        return ResponseEntity.ok(
                service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EventoRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent()
                .build();
    }
}