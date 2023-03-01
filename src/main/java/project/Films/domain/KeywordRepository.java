package project.Films.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KeywordRepository extends CrudRepository<Keyword, Long> {
	
	List<Keyword> findByName(String name);

}
