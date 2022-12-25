package br.com.mystatement.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "pluggy", url = "${feign.client.url.pluggy}")
public interface PluggyClient {
}
