package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.InsertClientUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertClientInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertClientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertClientConfig {

    @Bean
    public InsertClientInputPort insertClientInputPort(InsertClientOutputPort insertClientOutputPort){
        return new InsertClientUseCase(insertClientOutputPort);
    }
}
