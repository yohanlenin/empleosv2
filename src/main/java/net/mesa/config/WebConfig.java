package net.mesa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//@Value("${empleosapp.ruta.imagenes}")
		//private String rutaImagenes
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/"); // Linux
		registry.addResourceHandler("/logos/**").addResourceLocations("file:e:/empleito/img-vacantes/"); // Windows
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:" + rutaImagenes); // Windows

	}

}
