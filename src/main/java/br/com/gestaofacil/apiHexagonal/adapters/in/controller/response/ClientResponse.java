package br.com.gestaofacil.apiHexagonal.adapters.in.controller.response;

public record ClientResponse(
        Long id,
        String name,
        String cpf,
        String email
) {
}
