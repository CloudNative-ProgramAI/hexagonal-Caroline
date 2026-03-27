package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.adapters.out.DeleteClientAdapter;
import br.com.gestaofacil.apiHexagonal.application.core.usecase.DeleteClientUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClientConfig {

    @Bean
    public DeleteClientUseCase deleteClientUseCase(
            @Qualifier("deleteClientAdapter")
            DeleteClientAdapter deleteClientAdapter,
            @Qualifier("findClientByIdAdapter")
            FindClientByIdOutputPort findClientByIdOutputPort
    ) {
        return new DeleteClientUseCase(deleteClientAdapter, findClientByIdOutputPort);
    }
}
