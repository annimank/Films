package project.Films.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.Films.domain.Film;
import project.Films.domain.FilmRepository;

@Controller
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	
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
	

}
