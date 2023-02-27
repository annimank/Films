package project.films;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.films.domain.Film;
import project.films.domain.FilmRepository;

@SpringBootApplication
public class FilmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner films(FilmRepository filmRepository) {
		return (args) -> {
			filmRepository.save(new Film("Director", "gg", 1990, 120));
			filmRepository.save(new Film("Dire33ctor", "gyyg", 1940, 1620));
			filmRepository.save(new Film("Di22rector", "gggg", 1980, 20));
	
		}; 
	}

}
