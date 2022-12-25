package br.com.mystatement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static java.util.Collections.singleton;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "My Statement";

    @Value("${info.app.description}")
    private String projectDescription;

    @Value("${info.app.version}")
    private String projectVersion;

    @Value(value = "${my-statement.base.package}")
    private String basePackage;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage((basePackage)))
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .consumes(singleton(MediaType.APPLICATION_JSON_VALUE))
                .produces(singleton(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(projectDescription)
                .version(projectVersion)
                .build();
    }
}
