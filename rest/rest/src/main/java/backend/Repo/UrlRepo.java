package backend.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.Models.Url;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository<Url, Long>{
	
	List<Url> findAll();

	Url getById(Long id);

	boolean existsById(Long id);

	boolean existsByrealurl(String realurl);
	
	void deleteById(Long id);

	@Query("SELECT e FROM Url e WHERE CONCAT(e.realurl, e.tinyurl) LIKE %?1%")
	List<Url> getFilteredUrl(String searchKey);
	
	Optional<Url> findByrealurl(String realurl);


}