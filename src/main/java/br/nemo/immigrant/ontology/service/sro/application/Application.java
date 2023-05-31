package br.nemo.immigrant.ontology.service.sro.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.nemo.immigrant.ontology.service.sro.*"})
@EntityScan(basePackages = {"br.nemo.immigrant.ontology.entity.sro.*"})
@EnableJpaRepositories(basePackages = {"br.nemo.immigrant.ontology.service.sro.*"})
@OpenAPIDefinition(info = @Info(
  title = "sro",
  version = "1.0",
  description = "Scrum Reference Ontology (SRO) provides a common and comprehensive conceptualization about Scrum in the software development context and can be used to support application integration."))

public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
