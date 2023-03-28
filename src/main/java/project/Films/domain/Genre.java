package project.Films.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long genid;
	@Size(min = 1, max = 50)
	private String name;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "genre")
	
	//RESTISSÄ LISÄTTIIN TÄMÄ IGNORE, JÄÄ MUUTEEN IKUISEEN LOOPPIIN
	@JsonIgnore	
	private List<Film> films;
	
	public Genre() {}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public long getGenid() {
		return genid;
	}

	public void setGenid(long genid) {
		this.genid = genid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Genre [genid=" + genid + ", name=" + name + ", films=" + films + "]";
	}
	
	
	
}
