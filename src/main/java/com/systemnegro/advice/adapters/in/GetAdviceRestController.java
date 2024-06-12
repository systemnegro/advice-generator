package com.systemnegro.advice.adapters.in;


import com.systemnegro.advice.application.GetAdviceUseCase;
import com.systemnegro.advice.domain.model.Advice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advice")
public class GetAdviceRestController {

    private final GetAdviceUseCase adviceUseCase;

    public GetAdviceRestController(GetAdviceUseCase adviceUseCase) {
        this.adviceUseCase = adviceUseCase;
    }

    @GetMapping
    public Advice adviceGenerator() {
        String advice = adviceUseCase.execute();
        return new Advice(advice);
    }

    @GetMapping("/{id}")
    public Advice adviceGeneratorById(@PathVariable Long id) {
        String advice = adviceUseCase.execute(id);
        return new Advice(advice);
    }


}
