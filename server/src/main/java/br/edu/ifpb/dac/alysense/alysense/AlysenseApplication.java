package br.edu.ifpb.dac.alysense.alysense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.edu.ifpb.dac.alysense.alysense.business.service.RoleService;

@SpringBootApplication
@EnableWebMvc
public class AlysenseApplication implements WebMvcConfigurer,CommandLineRunner{

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(AlysenseApplication.class, args);
	}

	public void addCorsMappings(CorsRegistry registry){
		registry
		.addMapping("/**")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH");
	}

	@Override
	public void run(String... args) throws Exception {
		roleService.createDefaultValues();
		
	}

}
