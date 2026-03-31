package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindSupplierByIdInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FindSupplierByIdUseCase implements FindSupplierByIdInputPort {

    private final FindSupplierByIdOutputPort findSupplierByIdOutputPort;

    public FindSupplierByIdUseCase(FindSupplierByIdOutputPort findSupplierByIdOutputPort) {
        this.findSupplierByIdOutputPort = findSupplierByIdOutputPort;
    }


    @Override
    public Supplier findSupplierById(Long id) {
        return findSupplierByIdOutputPort.findSupplierById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));
    }
}
