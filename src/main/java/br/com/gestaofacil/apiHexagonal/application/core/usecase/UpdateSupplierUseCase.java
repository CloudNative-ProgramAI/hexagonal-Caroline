package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.UpdateSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateSupplierOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UpdateSupplierUseCase implements UpdateSupplierInputPort {

    private final UpdateSupplierOutputPort updateSupplierOutputPort;

    private final FindSupplierByIdOutputPort findSupplierByIdOutputPort;

    public UpdateSupplierUseCase(UpdateSupplierOutputPort updateSupplierOutputPort, FindSupplierByIdOutputPort findSupplierByIdOutputPort) {
        this.updateSupplierOutputPort = updateSupplierOutputPort;
        this.findSupplierByIdOutputPort = findSupplierByIdOutputPort;
    }


    @Override
    public void updateSupplier(Supplier supplier) {
        Supplier supplierUpdade = findSupplierByIdOutputPort.findSupplierById(supplier.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"));

        supplierUpdade.setNomeFantasia(supplier.getNomeFantasia());
        supplierUpdade.setEmail(supplier.getEmail());
        supplierUpdade.setCnpj(supplier.getCnpj());
        supplierUpdade.setTipoSupplier(supplier.getTipoSupplier());
        supplierUpdade.setAddress(supplier.getAddress());

        updateSupplierOutputPort.updateSupplier(supplierUpdade);
    }
}
