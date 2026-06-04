package br.com.dendeeventos.dto.response;

public record OrganizadorResponseDTO(
        Long id,
        String nome,
        String email,
        String nomeFantasia
) {
}