package config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Configuration pilotée par des annotation
@Configuration
//activer la recherche de beans Spring
@ComponentScan({"dev"})
@PropertySource("app.properties")
public class AppConfig {

	
	// constructeur de bean car classe particulière comme on ne peut pas toucher au JDK pour ajouter les annotation
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	
}
