package br.com.mystatement.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PluggyConnectorsResponseDto {

    private String total;
    private String totalPages;
    private String page;
    private List<PluggyConnectorsResultsResponseDto> results;
}
