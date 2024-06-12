package com.systemnegro.advice;

import com.systemnegro.advice.application.GetAdviceUseCase;
import com.systemnegro.advice.domain.ports.AdviceSlipService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class AdviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdviceApplication.class, args);
    }

    @Bean
    public GetAdviceUseCase provideAdviceUseCase(AdviceSlipService adviceSlip) {
        return new GetAdviceUseCase(adviceSlip);
    }

}
