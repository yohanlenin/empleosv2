package net.mesa.empleosv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="net.mesa")
@EnableJpaRepositories("net.mesa.repository")

// El cambio está en la siguiente anotación, 
//le tienes que indicar donde estan las entidades, de lo contrario no pueden ser usadas como tal.
@EntityScan("net.mesa.model")
public class Empleosv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Empleosv2Application.class, args);
	}

}
