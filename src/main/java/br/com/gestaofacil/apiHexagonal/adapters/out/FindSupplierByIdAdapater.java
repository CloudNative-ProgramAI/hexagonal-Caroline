package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.SupplierRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.SupplierEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("findSupplierByIdAdapter")
public class FindSupplierByIdAdapater implements FindSupplierByIdOutputPort {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;


    @Override
    public Optional<Supplier> findSupplierById(Long id) {
        return supplierRepository.findById(id)
                .map(supplierEntityMapper::toSupplierDomain);
    }
}
