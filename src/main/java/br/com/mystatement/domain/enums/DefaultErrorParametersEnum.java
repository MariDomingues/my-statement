package br.com.mystatement.domain.enums;

import lombok.Getter;

@Getter
public enum DefaultErrorParametersEnum {
    ERROR_TYPE("error.generic.type"),
    ERROR_TYPE_ALERT("error.generic.type.alert");

    private final String messageKey;

    DefaultErrorParametersEnum(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return messageKey;
    }
}