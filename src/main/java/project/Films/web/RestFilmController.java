package project.Films.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.Films.domain.Film;
import project.Films.domain.FilmRepository;

@RestController
public class RestFilmController {
	
	@Autowired
	FilmRepository filmRepository;
	
	//get all
	@GetMapping("/films")
	public Iterable<Film> getFilms() {
		return filmRepository.findAll();
	}
	
	// get one by id
	@GetMapping("/films/{id}")
	public Optional<Film> getFilm(@PathVariable Long id) {
		return filmRepository.findById(id);
	}
		
	// add a new book
	@PostMapping("films")
	Film newFilm(@RequestBody Film newFilm) {
		return filmRepository.save(newFilm);
	}
	
	// edit 
	@PutMapping("/films/{id}")
	Film editFilm(@RequestBody Film editedFilm, @PathVariable Long id) {
		editedFilm.setId(id);
		return filmRepository.save(editedFilm);
	}
	
	// delete
	@DeleteMapping("films/{id}")
	public Iterable<Film> deleteFilm(@PathVariable Long id) {
		filmRepository.deleteById(id);
		return filmRepository.findAll();
	}
			
	
}
