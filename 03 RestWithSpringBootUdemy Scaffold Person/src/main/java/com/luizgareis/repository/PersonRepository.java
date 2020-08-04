package com.luizgareis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luizgareis.data.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
