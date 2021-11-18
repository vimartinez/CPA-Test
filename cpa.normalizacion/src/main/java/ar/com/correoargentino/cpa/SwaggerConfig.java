package ar.com.correoargentino.cpa;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ar.com.correoargentino.cpa.web"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API Servicio CPA",
				"Prototipo del servicio CPA para prueba",
				"1.0",
				"http://www.correoargeentino.com.ar/cpa",
				new Contact("Correo Argentino", "http://www.correoargentino.com.ar", "info@correoargentino.com.ar"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
