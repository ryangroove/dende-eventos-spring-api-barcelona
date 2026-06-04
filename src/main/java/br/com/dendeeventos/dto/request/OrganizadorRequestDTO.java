package br.com.dendeeventos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record OrganizadorRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve possuir entre 3 e 100 caracteres")
        String nome,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "O sexo é obrigatório")
        String sexo,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "O CNPJ é obrigatório")
        String cnpj,

        @NotBlank(message = "A razão social é obrigatória")
        String razaoSocial,

        @NotBlank(message = "O nome fantasia é obrigatório")
        String nomeFantasia

) {
}