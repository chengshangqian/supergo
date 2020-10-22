package com.supergo.portal.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2 API在线文档配置类
 * 2.x版本和3.x版本访问的首页地址不一样，2.x版本是/swagger-ui.html，3.x版本是/swagger-ui/index.html
 */
@Configuration
@ConditionalOnProperty(value = "swagger.enabled", havingValue = "true", matchIfMissing = true) // 加个开关
@EnableOpenApi // 如果是2.x版本，使用@EnableSwagger2注解开启。如果项目开启了自动装配@EnableAutoConfiguration或@SpringBootApplication则可以不配置开启注解。
public class Swagger3Config {
    @Bean
    public Docket restApiDocket() {

        // 创建3.0版本的文档类型
        return new Docket(DocumentationType.OAS_30) // 2.x版本的文档类型为DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())
                .select()

                // 扫描包路径类方式
                //.apis(RequestHandlerSelectors.basePackage("com.supergo.portal.controller"))

                // 扫描指定注解方式
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)
                       .and(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)))

                .paths(PathSelectors.any())
                .build()

                // 添加全局访问令牌
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())

                // 支持的通讯协议集合
                //.protocols(Arrays.stream(new String[]{"https", "http"}).collect(Collectors.toSet()))
                ;

    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(new ApiKey("Authorization", "Authorization", "header"));
        return securitySchemes;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商家管理系统")
                .description("商品管理服务API、订单管理服务API以及分类管理服务API等，目前处于1.0版本，后续会有更多的API上线，敬请关注！")
                .version("1.0")
                .build();
    }
}
