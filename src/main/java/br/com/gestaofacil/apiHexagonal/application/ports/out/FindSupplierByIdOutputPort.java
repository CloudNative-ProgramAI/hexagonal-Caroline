package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

import java.util.Optional;

public interface FindSupplierByIdOutputPort {

    Optional<Supplier> findSupplierById(Long id);
}
