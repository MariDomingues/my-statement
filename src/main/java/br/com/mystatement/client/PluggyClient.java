package br.com.mystatement.client;

import br.com.mystatement.domain.dto.PluggyApiKeyRequestDto;
import br.com.mystatement.domain.dto.PluggyApiKeyResponseDto;
import br.com.mystatement.domain.dto.PluggyConnectorsResponseDto;
import br.com.mystatement.domain.dto.PluggyTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import static br.com.mystatement.utils.ConstantsUtils.X_API_KEY;

@FeignClient(value = "pluggy", url = "${feign.client.url.pluggy}")
public interface PluggyClient {

    @PostMapping("/auth")
    PluggyApiKeyResponseDto getApiKey(
            @RequestBody PluggyApiKeyRequestDto pluggyApiKeyRequestDto);

    @PostMapping("/connect_token")
    PluggyTokenResponseDto getToken(
            @RequestHeader(name = X_API_KEY) String apiKey);

    @GetMapping("/connectors")
    PluggyConnectorsResponseDto getConnectors(
            @RequestHeader(name = X_API_KEY) String pluggyApiKeyRequestDto,
            @RequestParam(name = "countries") String country,
            @RequestParam(name = "types") String... types);
}
