package br.com.gestaofacil.apiHexagonal.application.ports.in;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

import java.util.List;

public interface FindAllSuppliersInputPort {

    List<Supplier> findAllSuppliers();
}
