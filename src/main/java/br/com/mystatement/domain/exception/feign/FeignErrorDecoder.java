package br.com.mystatement.domain.exception.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static feign.FeignException.errorStatus;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    private static final String PATH = "path";

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("Error took place when using Feign client to send HTTP Request.");
        log.error("HTTP Method = " + response.request().httpMethod().name());
        log.error("URL = " + response.request().url());
        log.error("Status code = " + response.status());
        log.error("MethodKey = " + methodKey);

        FeignException feignException = errorStatus(methodKey, response);

        if (!feignException.contentUTF8().isEmpty()) {
            String value = feignException.contentUTF8();
            if (!value.equals("{}") && !value.contains(PATH)) {
                log.error("Content UTF8 = " + feignException.contentUTF8());
            }
        }

        return feignException;
    }

}
