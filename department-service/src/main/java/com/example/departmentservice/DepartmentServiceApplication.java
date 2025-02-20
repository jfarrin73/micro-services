package com.example.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Josh",
						email = "foo@example.com",
						url = "example.com"
				),
				license = @License(
						name = "MIT",
						url = "example.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Derpartment Service Doc",
				url = "external-example.com"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
