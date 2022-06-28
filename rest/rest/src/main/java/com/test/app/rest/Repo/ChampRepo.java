package com.test.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.app.rest.Models.Champion;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChampRepo extends JpaRepository<Champion, Long>{
	
	List<Champion> findAll();

	Champion getById(Long id);

	boolean existsById(Long id);

	void deleteById(Long id);

	@Query("SELECT e FROM Champion e WHERE CONCAT(e.name, e.lane, e.role, e.winrate, e.pickrate, e.counter) LIKE %?1%")
	List<Champion> getFilteredChampion(String searchKey);

}
