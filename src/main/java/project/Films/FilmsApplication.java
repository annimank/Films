package project.Films;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.Films.domain.Film;
import project.Films.domain.FilmRepository;
import project.Films.domain.Genre;
import project.Films.domain.GenreRepository;

@SpringBootApplication
public class FilmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner films(FilmRepository filmRepository, GenreRepository genreRepository) {
		return (args) -> {
			
			genreRepository.save(new Genre("Sci-Fi"));
			genreRepository.save(new Genre("Romance"));
			genreRepository.save(new Genre("Horror"));
			genreRepository.save(new Genre("Fantasy"));
			genreRepository.save(new Genre("Drama"));
			genreRepository.save(new Genre("Documentary"));
			genreRepository.save(new Genre("Historical"));
			genreRepository.save(new Genre("Comedy"));
			genreRepository.save(new Genre("Action"));
			
			filmRepository.save(new Film("Amélie", "Jean-Pierre Jeunet", 2001, 122, genreRepository.findByName("Romance").get(0)));
			filmRepository.save(new Film("The Shape of Water", "Guillermo del Toro", 2017, 123, genreRepository.findByName("Fantasy").get(0)));
			filmRepository.save(new Film("La La Land", "Damien Chazelle", 2016, 128, genreRepository.findByName("Drama").get(0)));
			filmRepository.save(new Film("Rough Night", "Lucia Aniello", 2017, 101, genreRepository.findByName("Comedy").get(0)));
			filmRepository.save(new Film("The Holiday", "Nancy Meyers", 2006, 136, genreRepository.findByName("Romance").get(0)));
			filmRepository.save(new Film("Jurassic Park", "Steven Spielberg", 1993, 127, genreRepository.findByName("Action").get(0)));
			filmRepository.save(new Film("My Octopus Teacer", "Pippa Ehrlich, James Reed", 2020, 85, genreRepository.findByName("Documentary").get(0)));
		};
	}
	

}
