package br.com.mystatement.service;

import br.com.mystatement.client.PluggyClient;
import br.com.mystatement.domain.dto.PluggyApiKeyRequestDto;
import br.com.mystatement.domain.dto.PluggyApiKeyResponseDto;
import br.com.mystatement.domain.dto.PluggyConnectorsResponseDto;
import br.com.mystatement.domain.dto.PluggyTokenResponseDto;
import br.com.mystatement.domain.enums.ConstCredentialsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static br.com.mystatement.domain.enums.ConnectorsTypeEnum.PERSONAL_BANK;
import static br.com.mystatement.utils.ConstantsUtils.BR;

@Service
public class PluggyService {

    @Autowired
    private PluggyClient pluggyClient;

    @Autowired
    private ReadTxtService readTxtService;

    public PluggyApiKeyResponseDto getAuth(String path) {

        Map<ConstCredentialsEnum, String> map =
                readTxtService.getArch(path, ConstCredentialsEnum.PLUGGY_CLIENT_ID, ConstCredentialsEnum.PLUGGY_CLIENT_SECRET);
        PluggyApiKeyRequestDto requestDto = new PluggyApiKeyRequestDto();

        requestDto.setClientId(map.get(ConstCredentialsEnum.PLUGGY_CLIENT_ID));
        requestDto.setClientSecret(map.get(ConstCredentialsEnum.PLUGGY_CLIENT_SECRET));

        PluggyApiKeyResponseDto apiKey = pluggyClient.getApiKey(requestDto);
        PluggyTokenResponseDto token = pluggyClient.getToken(apiKey.getApiKey());
        PluggyConnectorsResponseDto connectors = pluggyClient.getConnectors(token.getAccessToken(), BR, PERSONAL_BANK.getName());

        return apiKey;
    }
}
