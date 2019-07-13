//package com.arc.configurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @description:
// * @author: yechao
// * @date: 2018/10/112 11:17
// */
//@EnableSwagger2
//@Configuration
////@EnableConfigurationProperties
//public class Swagger2ApiConfiguration {
//
////    @Autowired
////    private Swagger2Properties prop;
////
////    @Bean
////    public Docket createRestApi() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(apiInfo())
////                .select()
////                .apis(RequestHandlerSelectors.basePackage(prop.getBasePackage()))
////                .paths(PathSelectors.any())
////                .build();
////    }
////
////    private ApiInfo apiInfo() {
////        return new ApiInfoBuilder()
////                .title(prop.getTitle())
////                .description(prop.getDescription())
////                .termsOfServiceUrl(prop.getTermsOfServiceUrl())
////                .contact(new Contact(prop.getContactName(), prop.getContactUrl(), prop.getContactEmail()))
////                .version(prop.getVersion())
////                .build();
////    }
//
////    /**
////     * 对于yml配置文件的的属性做映射
////     * 目的为了配置swagger2
////     */
////    @Getter
////    @Setter
////    @Component
////    @ConfigurationProperties(prefix = "swagger2")
////    public static class Swagger2Properties {
////
////        private String basePackage;
////
////        private String title;
////
////        private String description;
////
////        private String version;
////
////        private String termsOfServiceUrl;
////
////        private String contactName;
////
////        private String contactUrl;
////
////        private String contactEmail;
////
////    }
//
//
//    @Bean
//    public Docket customDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo1());
//    }
//
//    private ApiInfo apiInfo1() {
//        Contact contact = new Contact("小明", "http://www.cnblogs.com/getupmorning/", "zhaoming0018@126.com");
//        return new ApiInfoBuilder()
//                .title("前台API接口")
//                .description("前台API接口")
//                .contact(contact)
//                .version("1.1.0")
//                .build();
//    }
//}
