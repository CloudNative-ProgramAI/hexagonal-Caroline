package br.com.gestaofacil.apiHexagonal.adapters.in.controller.response;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.AddressDTO;
import br.com.gestaofacil.apiHexagonal.application.core.domain.TipoSupplierEnum;

public record SupplierResponse(
        Long id,
        String nomeFantasia,
        String email,
        String cnpj,
        TipoSupplierEnum tipoSupplier,
        AddressDTO address
) {
}
