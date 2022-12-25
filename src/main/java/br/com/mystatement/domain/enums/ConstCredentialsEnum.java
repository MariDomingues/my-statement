package br.com.mystatement.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstCredentialsEnum {

    PLUGGY_CLIENT_ID("pluggy-clientId"),
    PLUGGY_CLIENT_SECRET("pluggy-clientSecret");

    private String name;
}
