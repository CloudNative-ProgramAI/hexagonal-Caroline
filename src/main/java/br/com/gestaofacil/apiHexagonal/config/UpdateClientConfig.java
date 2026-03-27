package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.UpdateClientUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.UpdateClientInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateClientOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateClientConfig {

    @Bean
    public UpdateClientInputPort updateClientInputPort(
            @Qualifier("updateClientAdapter")
            UpdateClientOutputPort updateClientOutputPort,
            @Qualifier("updateClientAdapter")
            FindClientByIdOutputPort findClientByIdOutputPort
    ){
        return new UpdateClientUseCase(updateClientOutputPort, findClientByIdOutputPort);
    }

}
