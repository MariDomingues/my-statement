package br.com.mystatement.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PluggyConnectorsResultsCredentialsResponseDto {

    private String validation;
    private String validationMessage;
    private String label;
    private String name;
    private String type;
    private String placeholder;
    private String mfa;
    private String instructions;
    private String optional;
}
