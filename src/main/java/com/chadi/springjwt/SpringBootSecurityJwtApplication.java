package com.chadi.springjwt;

import com.chadi.springjwt.entity.Collaborator;
import com.chadi.springjwt.entity.Role;
import com.chadi.springjwt.repository.CollaboratorRepository;
import com.chadi.springjwt.service.CollaboratorService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class SpringBootSecurityJwtApplication {

	private final PasswordEncoder passwordEncoder;
	private final CollaboratorService collaboratorService;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	CommandLineRunner commandLineRunner(CollaboratorRepository repository) {
		return args -> {
			collaboratorService.saveRole(new Role(null, "ROLE_USER"));
			collaboratorService.saveRole(new Role(null, "ROLE_MANAGER"));
			collaboratorService.saveRole(new Role(null, "ROLE_ADMIN"));

			collaboratorService.saveCollaborator(new Collaborator(null, "john", "1234", "Jhon", "Travlota", "avatar", "code", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
			collaboratorService.saveCollaborator(new Collaborator(null, "chadi", "1234", "Chadi", "Abdelkader", "avatar", "code", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
			collaboratorService.saveCollaborator(new Collaborator(null, "heni", "1234", "Heni", "Hendaoui", "avatar", "code", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
			collaboratorService.saveCollaborator(new Collaborator(null, "arnold", "1234", "Arnold", "Shwarzeneger", "avatar", "code", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));

			collaboratorService.addRoleToCollaborator("john", "ROLE_USER");
			collaboratorService.addRoleToCollaborator("chadi", "ROLE_MANAGER");
			collaboratorService.addRoleToCollaborator("heni", "ROLE_ADMIN");
			collaboratorService.addRoleToCollaborator("arnold", "ROLE_ADMIN");
			collaboratorService.addRoleToCollaborator("arnold", "ROLE_ADMIN");
			collaboratorService.addRoleToCollaborator("arnold", "ROLE_USER");
		};
	}
}
