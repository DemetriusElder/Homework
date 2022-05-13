package com.test.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.app.rest.Models.User;

public interface UserRepo extends JpaRepository<User,Long>{
	

}
