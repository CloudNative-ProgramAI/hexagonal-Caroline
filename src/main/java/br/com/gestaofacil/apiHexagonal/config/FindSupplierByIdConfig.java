package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.FindSupplierByIdUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindSupplierByIdInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSupplierByIdConfig {

    @Bean
    public FindSupplierByIdInputPort findSupplierByIdInputPort(FindSupplierByIdOutputPort findSupplierByIdOutputPort) {
        return new FindSupplierByIdUseCase(findSupplierByIdOutputPort);
    }
}
