package br.com.dendeeventos.mapper;

import br.com.dendeeventos.dto.request.UsuarioRequestDTO;
import br.com.dendeeventos.dto.response.UsuarioResponseDTO;
import br.com.dendeeventos.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(
            UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setSexo(dto.sexo());
        usuario.setEmail(dto.email());

        return usuario;
    }

    public UsuarioResponseDTO toResponse(
            Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}