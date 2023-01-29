package com.example.amit.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.amit.entities.User;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM User", nativeQuery=true) 
	public List<User> getAllUser();
	
	@Query(value = "SELECT * FROM User order by id asc limit :limit", nativeQuery=true) 
	public Optional<List<User>> getTopNUser(@Param("limit") int limit);
	
	@Query(value = "SELECT * from user where DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), dob)), '%Y')>=:age", nativeQuery=true) 
	public Optional<List<User>> getUserDob(@Param("age") int age);
}
