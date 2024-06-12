package com.systemnegro.advice.application;


import com.systemnegro.advice.domain.ports.AdviceSlipService;


public class GetAdviceUseCase {
    private final AdviceSlipService adviceSlip;

    public GetAdviceUseCase(AdviceSlipService adviceSlip) {
        this.adviceSlip = adviceSlip;
    }

    public String execute() {
        return adviceSlip.getAdvice();
    }

    public String execute(Long id) {
        return adviceSlip.getAdvice(id);
    }
}
