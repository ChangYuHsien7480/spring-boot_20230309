package com.example.demo.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//     可能是spring-boot版本過高導致的錯誤
//     Failed to start bean 'documentationPluginsBootstrapper'; nested exception is
//     java.lang.NullPointerException: Cannot invoke
//     "org.springframework.web.servlet.mvc.condition.PatternsRequestCondition.toString()"
//     because the return value of
//     "springfox.documentation.spi.service.contexts.Orderings.patternsCondition(springfox.documentation.RequestHandler)"
//     is null
    @Bean
    public Docket swaggerSetting() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("logistics platform")
                .description("Read me~~\n" +
                        "")
                .version("v0.0.0.0")
                .build();
    }
}