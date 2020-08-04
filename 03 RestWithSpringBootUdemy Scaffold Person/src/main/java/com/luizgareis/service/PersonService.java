package com.luizgareis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgareis.converter.DozerConverter;
import com.luizgareis.converter.PersonConverter;
import com.luizgareis.data.dto.PersonDTO;
import com.luizgareis.data.dto.v2.PersonDTOV2;
import com.luizgareis.data.models.Person;
import com.luizgareis.exception.ResourceNotFoundException;
import com.luizgareis.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonConverter converter;
	
	public PersonDTO findById(Long id) {
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		
		return DozerConverter.perseObject(repository.save(entity), PersonDTO.class);
	}
	
	public List<PersonDTO> findAll() {
		return DozerConverter.perseListObjects(repository.findAll(), PersonDTO.class);
	}
	
	public PersonDTO create(PersonDTO person) {
		var entity = DozerConverter.perseObject(person, Person.class);
		var vo = DozerConverter.perseObject(repository.save(entity), PersonDTO.class);
		return vo;
	}
	
	public PersonDTOV2 createV2(PersonDTOV2 personV2) {
		var entity = converter.converterDTOToEntity(personV2);
		var vo = converter.converterEntityToDTO(repository.save(entity));
		return vo;
	}
	
	public PersonDTO update(PersonDTO person) {
		var entity =  repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		var vo = DozerConverter.perseObject(repository.save(entity), PersonDTO.class);
		return vo;
	}
	
	public void delete(Long id) {
		PersonDTO entity = findById(id);
		repository.delete(DozerConverter.perseObject(entity, Person.class));
	}
	
}
