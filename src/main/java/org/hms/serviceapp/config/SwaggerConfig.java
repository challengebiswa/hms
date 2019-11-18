package org.hms.serviceapp.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.hms.serviceapp.controller"))
                .paths(regex("/hms.*"))
                .build()
                .pathMapping("/")				
				.securitySchemes(Arrays.asList(apiKey()))
				.securityContexts(Arrays.asList(securityContext()))
                .apiInfo(metaData())
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Accept")                                
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .defaultValue("application/json")
                                .required(true)
                                .build()/*,
                                new ParameterBuilder()
                                .name("Accept")                                
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()*/));
    }
   
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("HMS Application")
                .version("1.0.0")
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    private ApiKey apiKey() {
		return new ApiKey("apiKey", "Authorization", "header");
	}

	
	
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/api.*"))
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
	}
	@Bean
	public SecurityConfiguration security() {
			return SecurityConfigurationBuilder.builder()
					.clientId("test-app-client-id")
					.clientSecret("test-app-client-secret")
					.realm("test-app-realm")
					.appName("test-app")
					.scopeSeparator(",")
					.additionalQueryStringParams(null)
					.useBasicAuthenticationWithAccessCodeGrant(false)
					.build();
	}
}
