package com.luizgareis.converter;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.luizgareis.data.dto.v2.PersonDTOV2;
import com.luizgareis.data.models.Person;

@Service
public class PersonConverter {

		public PersonDTOV2 converterEntityToDTO(Person person) {
			PersonDTOV2 dto = new PersonDTOV2();
			dto.setId(person.getId());
			dto.setAddress(person.getAddress());
			dto.setBirthday(new Date());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setGender(person.getGender());
			
			return dto;
		}
		
		public Person converterDTOToEntity(PersonDTOV2 person) {
			Person dto = new Person();
			dto.setId(person.getId());
			dto.setAddress(person.getAddress());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setGender(person.getGender());
			
			return dto;
		}
}
