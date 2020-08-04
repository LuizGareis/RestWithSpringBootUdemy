package com.luizgareis.mocks;

import java.util.ArrayList;
import java.util.List;

import com.luizgareis.data.dto.PersonDTO;
import com.luizgareis.data.models.Person;

public class MockPerson {
	
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonDTO mockDTO() {
		return mockDTO(0);
	}
	
	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	
	public List<PersonDTO> mockDTOList() {
		List<PersonDTO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockDTO(i));
		}
		return persons;
	}
	
	
	private Person mockEntity(Integer number) {
		Person person = new Person();
		
		person.setAddress("ADDRESS 1");
		person.setFirstName("Entity");
		person.setLastName("LastEntity");
		person.setGender("Male");
		person.setId(number.longValue());
		return person;
	}
	
	private PersonDTO mockDTO(Integer number) {
		PersonDTO person = new PersonDTO();
		
		person.setAddress("ADDRESS MOCK");
		person.setFirstName("Mock");
		person.setLastName("LastMock");
		person.setGender("Male");
		person.setId(number.longValue());
		return person;
	}
	
}
