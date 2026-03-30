package br.com.gestaofacil.apiHexagonal.adapters.in.controller;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper.SupplierMapper;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.SupplierRequest;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertSupplierInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    @Autowired
    private InsertSupplierInputPort insertSupplierInputPort;

    @Autowired
    private SupplierMapper supplierMapper;


    @PostMapping
    public ResponseEntity<Void> insetSupplier(@Valid @RequestBody SupplierRequest supplierRequest) {
        Supplier supplier = supplierMapper.toSupplier(supplierRequest);
        insertSupplierInputPort.insertSupplier(supplier);
        return ResponseEntity.ok().build();
    }

}
