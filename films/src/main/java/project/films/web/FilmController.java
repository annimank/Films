package project.films.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.films.domain.Film;
import project.films.domain.FilmRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@RequestMapping("/index")
	public String Films() {
		return "index";
	}
	
	@RequestMapping(value= {"filmlist", "/"})
	public String filmlist(Model model) {
		model.addAttribute("film", filmRepository.findAll());
		return "filmlist";
	}

	@PostMapping("/save")
	public String save(Film film, Model model) {
		filmRepository.save(film);
		return "redirect:/filmlist";
	}
}
