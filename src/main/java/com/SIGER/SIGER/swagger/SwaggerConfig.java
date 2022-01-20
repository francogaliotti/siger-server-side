package com.SIGER.SIGER.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  private static final String BASE_PACKAGE = "com.SIGER.SIGER.controllers";
  private static final String TITLE = "SIGER DPV-MZA";
  private static final String API_KEY_KEYNAME = "Authorization";
  private static final String API_KEY_NAME = "JWT";
  private static final String API_KEY_PASS_AS = "header";
  private static final String SCOPE = "global";
  private static final String SCOPE_DESCRIPTION = "accessEverything";
  private static final String DESCRIPTION = "Gubernamental Organization aimed to build and maintain "
      + "Mendoza Province´s road and streets";

  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .info(new Info()
            .title(TITLE)
            .description(DESCRIPTION)
        );
  }

}
