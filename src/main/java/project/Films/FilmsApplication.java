package project.Films;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.Films.domain.Film;
import project.Films.domain.FilmRepository;

@SpringBootApplication
public class FilmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner plants(FilmRepository filmRepository) {
		return (args) -> {
			
			
			filmRepository.save(new Film("Amélie", "Jean-Pierre Jeunet", 2001, 122));
			filmRepository.save(new Film("The Shape of Water", "Guillermo del Toro", 2017, 123));
			filmRepository.save(new Film("La La Land", "Damien Chazelle", 2016, 128));
			filmRepository.save(new Film("Rough Night", "Lucia Aniello", 2017, 101));
		};
	}
	

}
