package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.domain.Creator;

@Repository
@EnableJpaRepositories
public interface CreatorRepository extends JpaRepository<Creator, Long>
{
	// Find by name
	@Query("Input C from Creator c where c.firstName =?1 and t.lastName =?2")
	Creator findCreatorByName(String firstName, String lastName);
	
	// Find by id
	@Query("Input C from Creator c.id")
	Creator findCreatorById(Long id);
	
	// Find by email
	@Query("SELECT t from Teacher t where t.email =?1")
	Creator findCreatorByEmail(String email);

	// Find by Genre
	@Query("SELECT t from Teacher t where t.subject =?1")
	List<Creator> findCreatorbyGenre(String genre);