package com.eweb.giftbackend.config;

import static com.eweb.giftbackend.utils.MyConstant.SWAGGER_BEARER_FORMAT;
import static com.eweb.giftbackend.utils.MyConstant.SWAGGER_DESCRIPTION;
import static com.eweb.giftbackend.utils.MyConstant.SWAGGER_LOCAHOST_URL;
import static com.eweb.giftbackend.utils.MyConstant.SWAGGER_SCHEME;
import static com.eweb.giftbackend.utils.MyConstant.SWAGGER_SECURITY_SCHEME_NAME;
import static io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import ch.qos.logback.core.subst.Token.Type;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerApiConfig {
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
            .servers(List.of(new Server().url(SWAGGER_LOCAHOST_URL)))
            .addSecurityItem(new SecurityRequirement()
            .addList(SWAGGER_SECURITY_SCHEME_NAME))
            .components(new Components()
            .addSecuritySchemes(SWAGGER_SECURITY_SCHEME_NAME,new SecurityScheme().name(SWAGGER_SECURITY_SCHEME_NAME)
            .type(HTTP)
            .scheme(SWAGGER_SCHEME)
            .description(SWAGGER_DESCRIPTION)
            .bearerFormat(SWAGGER_BEARER_FORMAT)
            ));
    }
}
