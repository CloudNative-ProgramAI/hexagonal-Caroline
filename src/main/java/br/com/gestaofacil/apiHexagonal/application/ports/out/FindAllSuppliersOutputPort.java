package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

import java.util.List;

public interface FindAllSuppliersOutputPort {

    List<Supplier> findAllSuppliers();
}
