package br.com.mystatement.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConnectorsTypeEnum {

    PERSONAL_BANK("PERSONAL_BANK"),
    BUSINESS_BANK("BUSINESS_BANK"),
    INVESTMENT("INVESTMENT");

    private String name;
}
