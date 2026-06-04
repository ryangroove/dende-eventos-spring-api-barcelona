package br.com.dendeeventos.service;

import br.com.dendeeventos.dto.request.UsuarioRequestDTO;
import br.com.dendeeventos.dto.response.UsuarioResponseDTO;
import br.com.dendeeventos.entity.Usuario;
import br.com.dendeeventos.mapper.UsuarioMapper;
import br.com.dendeeventos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(
            UsuarioRepository repository,
            UsuarioMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public Usuario buscarEntidadePorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));
    }

    public UsuarioResponseDTO criar(
            UsuarioRequestDTO dto) {

        Usuario usuario = mapper.toEntity(dto);

        usuario = repository.save(usuario);

        return mapper.toResponse(usuario);
    }

    public List<UsuarioResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        return mapper.toResponse(
                buscarEntidadePorId(id)
        );
    }

    public UsuarioResponseDTO atualizar(
            Long id,
            UsuarioRequestDTO dto) {

        Usuario usuario =
                buscarEntidadePorId(id);

        usuario.setNome(dto.nome());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setSexo(dto.sexo());
        usuario.setEmail(dto.email());

        usuario = repository.save(usuario);

        return mapper.toResponse(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}