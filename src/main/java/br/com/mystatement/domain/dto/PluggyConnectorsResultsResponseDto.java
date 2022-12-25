package br.com.mystatement.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PluggyConnectorsResultsResponseDto {

    private String id;
    private String name;
    private String primaryColor;
    private String institutionUrl;
    private String country;
    private String type;
    private List<PluggyConnectorsResultsCredentialsResponseDto> credentials;
    private String imageUrl;
    private String hasMFA;
    private PluggyConnectorsResultsHealthResponseDto health;
    private List<String> products;
    private String createdAt;
}
