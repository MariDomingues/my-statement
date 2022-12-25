package br.com.mystatement.controller;

import br.com.mystatement.domain.dto.PluggyResponseDto;
import br.com.mystatement.service.PluggyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pluggy")
@Api(value = "PluggyController")
@Slf4j
public class PluggyController {

    @Autowired
    private PluggyService pluggyService;

    @GetMapping
    @ApiOperation(value = "Método responsável por obter a ApiKey")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    public PluggyResponseDto getAuth(@RequestHeader String path) {

        log.info("");
        return pluggyService.getAuth(path);
    }
}
