package br.com.dendeeventos.mapper;

import br.com.dendeeventos.dto.request.OrganizadorRequestDTO;
import br.com.dendeeventos.dto.response.OrganizadorResponseDTO;
import br.com.dendeeventos.entity.Organizador;
import org.springframework.stereotype.Component;

@Component
public class OrganizadorMapper {

    public Organizador toEntity(
            OrganizadorRequestDTO dto) {

        Organizador organizador = new Organizador();

        organizador.setNome(dto.nome());
        organizador.setDataNascimento(dto.dataNascimento());
        organizador.setSexo(dto.sexo());
        organizador.setEmail(dto.email());
        organizador.setCnpj(dto.cnpj());
        organizador.setRazaoSocial(dto.razaoSocial());
        organizador.setNomeFantasia(dto.nomeFantasia());

        return organizador;
    }

    public OrganizadorResponseDTO toResponse(
            Organizador organizador) {

        return new OrganizadorResponseDTO(
                organizador.getId(),
                organizador.getNome(),
                organizador.getEmail(),
                organizador.getNomeFantasia()
        );
    }
}