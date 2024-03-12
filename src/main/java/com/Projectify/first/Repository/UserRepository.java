package com.Projectify.first.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.Projectify.first.model.User;

@Component
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query(value="select id, username,password,email,name,phone from user where user.username=username",nativeQuery=true)
	
	User FindByUsername(String username);

}
