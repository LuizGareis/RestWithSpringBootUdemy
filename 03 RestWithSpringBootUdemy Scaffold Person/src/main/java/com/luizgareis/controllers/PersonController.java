package com.luizgareis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizgareis.data.dto.PersonDTO;
import com.luizgareis.data.dto.v2.PersonDTOV2;
import com.luizgareis.service.PersonService;

@RequestMapping(path = "api/v1/person", 
				produces = {"application/json","application/xml", "application/x-yaml"},
				consumes = {"application/json","application/xml", "application/x-yaml"})
@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/{id}")
	public PersonDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<PersonDTO> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public PersonDTO create(@RequestBody PersonDTO person) {
		return service.create(person);
	}
	
	@PostMapping("/v2")
	public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person) {
		return service.createV2(person);
	}
	
	@PutMapping
	public PersonDTO update(@RequestBody PersonDTO person) {
		return service.update(person);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return ResponseEntity.ok().build();
	}
	
}
