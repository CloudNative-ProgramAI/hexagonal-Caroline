package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.ports.in.DeleteSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteSupplierOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DeleteSupplierUseCase implements DeleteSupplierInputPort {

    private final DeleteSupplierOutputPort deleteSupplierOutputPort;

    private final FindSupplierByIdOutputPort findSupplierByIdOutputPort;

    public DeleteSupplierUseCase(DeleteSupplierOutputPort deleteSupplierOutputPort, FindSupplierByIdOutputPort findSupplierByIdOutputPort) {
        this.deleteSupplierOutputPort = deleteSupplierOutputPort;
        this.findSupplierByIdOutputPort = findSupplierByIdOutputPort;
    }

    @Override
    public void deleteSupplier(Long id) {
        findSupplierByIdOutputPort.findSupplierById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Fornecedor não encontrado"));

        deleteSupplierOutputPort.deleteSupplier(id);
    }
}
