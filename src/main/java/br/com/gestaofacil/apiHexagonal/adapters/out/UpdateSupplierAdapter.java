package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.SupplierRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.SupplierEntity;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.SupplierEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateSupplierOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("updateSupplierAdapter")
public class UpdateSupplierAdapter implements UpdateSupplierOutputPort, FindSupplierByIdOutputPort {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;


    @Override
    public Optional<Supplier> findSupplierById(Long id) {
        return supplierRepository.findById(id)
                .map(supplierEntityMapper::toSupplierDomain);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplier.getId())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado para persistência"));
        supplierEntityMapper.updateEntityFromDomain(supplier, supplierEntity);
        supplierRepository.save(supplierEntity);

    }
}
