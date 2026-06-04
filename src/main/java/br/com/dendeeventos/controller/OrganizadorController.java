package br.com.dendeeventos.controller;

import br.com.dendeeventos.dto.request.OrganizadorRequestDTO;
import br.com.dendeeventos.dto.response.OrganizadorResponseDTO;
import br.com.dendeeventos.service.OrganizadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {

    private final OrganizadorService service;

    public OrganizadorController(
            OrganizadorService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrganizadorResponseDTO> criar(
            @Valid @RequestBody OrganizadorRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrganizadorResponseDTO>> listar() {

        return ResponseEntity.ok(
                service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody OrganizadorRequestDTO dto) {

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