package br.com.mystatement.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PluggyApiKeyRequestDto {

    private String clientId;
    private String clientSecret;
}
