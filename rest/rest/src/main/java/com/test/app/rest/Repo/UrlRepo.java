package com.test.app.rest.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.app.rest.Models.Url;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository<Url, Long>{
	
	List<Url> getAll();

	Url getById(Long id);

	boolean existsById(Long id);

	boolean existsByRealUrl(String realUrl);
	
	void deleteById(Long id);

	@Query("SELECT e FROM Url e WHERE CONCAT(e.realUrl, e.tinyUrl) LIKE %?1%")
	List<Url> getFilteredUrl(String searchKey);
	
	Optional<Url> findByRealUrl(String realUrl);


}