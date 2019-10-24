package com.arc.core.config.configurations.swagger2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2的配置作为注解引入到您需要的项目中去
 * 注意需要在您的使用swagger2的项目中yml中增加配置
 *
 * @author yechao
 * @since 2018/11/12 11:17
 */
@EnableSwagger2
@Configuration
@EnableConfigurationProperties
public class Swagger2ApiConfiguration {

    @Autowired
    private Swagger2Properties prop;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(prop.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(prop.getTitle())
                .description(prop.getDescription())
                .termsOfServiceUrl(prop.getTermsOfServiceUrl())
                .contact(new Contact(prop.getContactName(), prop.getContactUrl(), prop.getContactEmail()))
                .version(prop.getVersion())
                .build();
    }

    /**
     * 对于yml配置文件的的属性做映射
     * 目的为了配置swagger2
     */
    @Getter
    @Setter
    @Component
    @ConfigurationProperties(prefix = "arc.swagger2")
    public static class Swagger2Properties {

        private String basePackage = "com";

        private String title = "文档";

        private String description = "默认配置扫描到的API";

        private String version = "0.0.1";

        private String termsOfServiceUrl = "/";

        private String contactName = "unknown";

        private String contactUrl = "unknown";

        private String contactEmail = "unknown";

    }

}
