package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.UpdateSupplierUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.UpdateSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateSupplierOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateSupplierConfig {

    @Bean
    public UpdateSupplierInputPort updateSupplierInputPort(
            @Qualifier("updateSupplierAdapter")
            UpdateSupplierOutputPort updateSupplierOutputPort,
            @Qualifier("updateSupplierAdapter")
            FindSupplierByIdOutputPort findSupplierByIdOutputPort
    ) {
        return new UpdateSupplierUseCase(updateSupplierOutputPort, findSupplierByIdOutputPort);
    }
}
