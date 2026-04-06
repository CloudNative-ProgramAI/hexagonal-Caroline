package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.DeleteSupplierUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.DeleteSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteSupplierOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindSupplierByIdOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteSupplierConfig {

    @Bean
    public DeleteSupplierInputPort deleteSupplierInputPort(
            @Qualifier("deleteSupplierAdapter")
            DeleteSupplierOutputPort deleteSupplierOutputPort,
            @Qualifier("findSupplierByIdAdapter")
            FindSupplierByIdOutputPort findSupplierByIdOutputPort
    ) {
        return new DeleteSupplierUseCase(deleteSupplierOutputPort, findSupplierByIdOutputPort);
    }
}
