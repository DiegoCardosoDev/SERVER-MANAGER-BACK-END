package com.diego.serversmanager.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.HashSet;

/*DOCUMENTAÇÃO DA API*/

/*http://localhost:8080/swagger-ui/index.html*/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {


    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diego.serversmanager.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build())
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

    private Contact contato() {
        return new Contact(
                "Diego Cardoso",
                "https://www.linkedin.com/in/diegocardosonogueira/",
                "diegocardososacramento@gmail.com");
    }



    private ApiInfoBuilder infoApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Servers Manager Api");
        apiInfoBuilder.description("gerenciador de servidores");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licence - by Diego Cardoso");
        apiInfoBuilder.licenseUrl("https://github.com/DiegoCardosoDev/SERVER-MANAGER-BACK-END");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }


}
