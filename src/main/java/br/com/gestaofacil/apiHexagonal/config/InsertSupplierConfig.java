package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.InsertSupplierUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertSupplierOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertSupplierConfig {

    @Bean
    public InsertSupplierInputPort insertSupplierInputPort(InsertSupplierOutputPort insertSupplierOutputPort) {
        return new InsertSupplierUseCase(insertSupplierOutputPort);
    }
}
