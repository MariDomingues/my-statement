package br.com.mystatement.service;

import br.com.mystatement.client.PluggyClient;
import br.com.mystatement.domain.dto.PluggyRequestDto;
import br.com.mystatement.domain.dto.PluggyResponseDto;
import br.com.mystatement.domain.enums.ConstCredentialsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PluggyService {

    @Autowired
    private PluggyClient pluggyClient;

    @Autowired
    private ReadTxtService readTxtService;

    public PluggyResponseDto getAuth(String path) {

        Map<ConstCredentialsEnum, String> map =
                readTxtService.getArch(path, ConstCredentialsEnum.PLUGGY_CLIENT_ID, ConstCredentialsEnum.PLUGGY_CLIENT_SECRET);
        PluggyRequestDto requestDto = new PluggyRequestDto();

        requestDto.setClientId(map.get(ConstCredentialsEnum.PLUGGY_CLIENT_ID));
        requestDto.setClientSecret(map.get(ConstCredentialsEnum.PLUGGY_CLIENT_SECRET));

        return pluggyClient.getApiKey(requestDto);
    }
}
