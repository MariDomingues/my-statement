package br.com.mystatement.client;

import br.com.mystatement.domain.dto.PluggyApiKeyRequestDto;
import br.com.mystatement.domain.dto.PluggyApiKeyResponseDto;
import br.com.mystatement.domain.dto.PluggyTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "pluggy", url = "${feign.client.url.pluggy}")
public interface PluggyClient {

    @PostMapping("/auth")
    PluggyApiKeyResponseDto getApiKey(@RequestBody PluggyApiKeyRequestDto pluggyApiKeyRequestDto);

    @PostMapping("/connect_token")
    PluggyTokenResponseDto getToken(@RequestHeader(name = "X-API-KEY") String pluggyApiKeyRequestDto);
}
