package br.com.dendeeventos.service;

import br.com.dendeeventos.dto.request.OrganizadorRequestDTO;
import br.com.dendeeventos.dto.response.OrganizadorResponseDTO;
import br.com.dendeeventos.entity.Organizador;
import br.com.dendeeventos.mapper.OrganizadorMapper;
import br.com.dendeeventos.repository.OrganizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorService {

    private final OrganizadorRepository repository;
    private final OrganizadorMapper mapper;

    public OrganizadorService(
            OrganizadorRepository repository,
            OrganizadorMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public OrganizadorResponseDTO criar(
            OrganizadorRequestDTO dto) {

        Organizador organizador =
                mapper.toEntity(dto);

        organizador =
                repository.save(organizador);

        return mapper.toResponse(organizador);
    }

    public List<OrganizadorResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public OrganizadorResponseDTO buscarPorId(Long id) {

        Organizador organizador = repository.findById(id)
                .orElseThrow();

        return mapper.toResponse(organizador);
    }

    public OrganizadorResponseDTO atualizar(
            Long id,
            OrganizadorRequestDTO dto) {

        Organizador organizador =
                repository.findById(id)
                        .orElseThrow();

        organizador.setNome(dto.nome());
        organizador.setDataNascimento(dto.dataNascimento());
        organizador.setSexo(dto.sexo());
        organizador.setEmail(dto.email());
        organizador.setCnpj(dto.cnpj());
        organizador.setRazaoSocial(dto.razaoSocial());
        organizador.setNomeFantasia(dto.nomeFantasia());

        organizador = repository.save(organizador);

        return mapper.toResponse(organizador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}