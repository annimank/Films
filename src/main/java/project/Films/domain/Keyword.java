package project.Films.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Keyword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long keyid;
	private String name;
	
	//Tähän ja kirjaan tulee ManyToMany -suhde
	
	public Keyword(String name) {
		super();
		this.name = name;
	}

	public Keyword() {}

	public long getKeyid() {
		return keyid;
	}

	public void setKeyid(long keyid) {
		this.keyid = keyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
