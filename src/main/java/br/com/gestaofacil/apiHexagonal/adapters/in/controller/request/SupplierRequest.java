package br.com.gestaofacil.apiHexagonal.adapters.in.controller.request;

import br.com.gestaofacil.apiHexagonal.application.core.domain.TipoSupplierEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record SupplierRequest(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100)
        String nomeFantasia,

        @Email(message = "Email inválido")
        String email,

        @CNPJ(message = "CNPJ inválido")
        String cnpj,

        @NotNull(message = "Tipo do Fornecedor é obrigatório")
        TipoSupplierEnum tipoSupplier,

        @Valid AddressDTO address
) {
}
