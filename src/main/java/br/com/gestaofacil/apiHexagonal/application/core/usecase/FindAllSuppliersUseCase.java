package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindAllSuppliersInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllSuppliersOutputPort;

import java.util.List;

public class FindAllSuppliersUseCase implements FindAllSuppliersInputPort {

    private final FindAllSuppliersOutputPort findAllSuppliersOutputPort;

    public FindAllSuppliersUseCase(FindAllSuppliersOutputPort findAllSuppliersOutputPort) {
        this.findAllSuppliersOutputPort = findAllSuppliersOutputPort;
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        return findAllSuppliersOutputPort.findAllSuppliers();
    }
}
