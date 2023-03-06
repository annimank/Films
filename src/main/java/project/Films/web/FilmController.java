package project.Films.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Films.domain.Film;
import project.Films.domain.FilmRepository;
import project.Films.domain.GenreRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	//login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
	
	@RequestMapping("/index")
	public String Films() {
		return "index";
	}
	
	@RequestMapping(value = {"filmlist", "/"})
	public String Filmlist(Model model) {
		model.addAttribute("films", filmRepository.findAll());
		return "filmlist";
	}
	
	@PostMapping("/save")
    public String save(Film film, Model model) {
    	filmRepository.save(film);
    	return "redirect:/filmlist";
	}
	
	@GetMapping("/add")
	public String newFilm(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("genres", genreRepository.findAll());
		return "addfilm";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteFilm(@PathVariable("id") long id, Model model) {
		filmRepository.deleteById(id);
		return "redirect:/filmlist";
	}
	
	@GetMapping("editfilm/{id}")
	public String editfilm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editfilm", filmRepository.findById(id));
		model.addAttribute("genres", genreRepository.findAll());
		return "editfilm";
	}

}
