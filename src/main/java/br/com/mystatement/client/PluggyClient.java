package br.com.mystatement.client;

import br.com.mystatement.domain.dto.PluggyRequestDto;
import br.com.mystatement.domain.dto.PluggyResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "pluggy", url = "${feign.client.url.pluggy}")
public interface PluggyClient {

    @PostMapping("/auth")
    public PluggyResponseDto getApiKey(@RequestBody PluggyRequestDto pluggyRequestDto);
}
