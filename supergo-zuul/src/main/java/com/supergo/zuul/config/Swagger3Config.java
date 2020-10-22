package com.supergo.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

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
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(Swagger3Config.class);

    @Bean
    public Docket restApiDocket() {
        // 创建3.0版本的文档类型
        return new Docket(DocumentationType.OAS_30) // 2.x版本的文档类型为DocumentationType.SWAGGER_2
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商家管理系统")
                .description("商品管理服务API、订单管理服务API以及分类管理服务API等，目前处于1.0版本，后续会有更多的API上线，敬请关注！")
                .version("1.0")
                .build();
    }


    /**
     * 配置API文档数据来源
     */
    @Component
    @Primary
    class SwaggerResourceConfig implements SwaggerResourcesProvider {

        // 每个微服务下Swagger的API文档数据来源获取相对路径
        private final String swaggerApiPath = "/v3/api-docs"; // 2.x版本为 /v2/api-docs
        private final String routePathSuffix = "/**"; // 真实请求后缀，将被swaggerApiPath替换以构造API文档数据来源

        // 路由定义器：持有路由的对象
        @Autowired
        RouteLocator routeLocator;

        /**
         * 获取API文档数据库来源
         *
         * @return
         */
        @Override
        public List<SwaggerResource> get() {
            //Swagger文档json来源
            List<SwaggerResource> resources = new ArrayList<>();

            //获得网关路由路径
            List<Route> routes = routeLocator.getRoutes();
            //遍历每个微服务路由路径
            for (Route route : routes) {
                //添加swagger 文档json获取的路径
                String routeFullPath = route.getFullPath();
                // zuul会自动注册一个以serviceId为名称的路由，为了查看更直观并避免重复，使用服务id的路由构建API文档来源
                // 这里默认认为所有服务id包含-符号
                String routeId = route.getId();
                if(routeId.contains("-")) {
                    // 把路由完整路径中最后的/**替换为API数据源文档相对路径/v3/api-docs，以构建API数据来源
                    String swaggerResourceLocation = routeFullPath.replace(routePathSuffix, swaggerApiPath);
                    resources.add(swaggerResource(routeId, swaggerResourceLocation));
                    if(LOGGER.isDebugEnabled()){
                        LOGGER.debug("检测到[{}]服务路由{}，尝试获取该服务API数据资源路径：{}",routeId,routeFullPath,swaggerResourceLocation);
                    }
                }
            }

            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion("3.0");
            return swaggerResource;
        }
    }
}
