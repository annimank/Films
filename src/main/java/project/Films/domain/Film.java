package project.Films.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, director;
	private int relYear, duration;
	
	//going to add a keyword- manytomany -structure
	
	@ManyToOne
	@JoinColumn(name = "genid")
	private Genre genre;
	
	public Film() {}

	public Film(String title, String director, int relYear, int duration, Genre genre) {
		super();
		this.title = title;
		this.director = director;
		this.relYear = relYear;
		this.duration = duration;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRelYear() {
		return relYear;
	}

	public void setRelYear(int relYear) {
		this.relYear = relYear;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", director=" + director + ", relYear=" + relYear + ", duration="
				+ duration + ", genre=" + genre + "]";
	}

	
	

}
