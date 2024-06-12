package com.systemnegro.advice.adapters.out;


import com.systemnegro.advice.adapters.out.exception.AdviceNotFoundException;
import com.systemnegro.advice.adapters.out.exception.ApiCommunicationException;
import com.systemnegro.advice.domain.ports.AdviceSlipService;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "adviceApi", url = "${advice.base-url}")
public interface AdviceGeneratorApiService extends AdviceSlipService {


    @GetMapping("/advice")
    String adviceResp();

    @GetMapping("/advice/{id}")
    String adviceResp(@PathVariable Long id);

    @Override
    default String getAdvice() throws ApiCommunicationException {
        try {
            return adviceResp();
        } catch (FeignException httpError) {
            throw new ApiCommunicationException();
        }
    }

    default String getAdvice(Long id) throws ApiCommunicationException, AdviceNotFoundException {
        //AdviceResponse response = adviceResp(id);

//        if (response.message() != null && "error".equals(response.message().type())) {
//            throw new ApiCommunicationException();
//        }
        String error = "{\"message\": {\"type\": \"error\", \"text\": \"Advice slip not found.\"}}";


        try {
            String response = adviceResp(id);

            if (response.equals(error)) {
                throw new AdviceNotFoundException();
            }
            return response;

        } catch (FeignException httpError) {
            throw new ApiCommunicationException();
        }
    }


//    record AdviceResponse(Message message, Slip slip) {
//    }
//
//    record Message(String type, String text) {
//    }
//
//    record Slip(String advice) {
//    }
}
