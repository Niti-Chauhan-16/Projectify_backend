package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.User;


interface UserRepository extends JpaRepository<User,String>{
	
	

}
