package ait.cohort46.person.service;

import ait.cohort46.person.dao.PersonRepository;
import ait.cohort46.person.dto.AddressDto;
import ait.cohort46.person.dto.CityPopulationDto;
import ait.cohort46.person.dto.PersonDto;
import ait.cohort46.person.dto.exceptions.PersonNotFoundException;
import ait.cohort46.person.model.Address;
import ait.cohort46.person.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Boolean addPerson(PersonDto person) {
        if (repository.findById(person.getId()).isPresent()) {
            return false;
        }
        repository.save(modelMapper.map(person, Person.class));
        return true;
    }

    @Override
    public PersonDto findPerson(int id) {
        Person person = repository.findById(id).orElseThrow(PersonNotFoundException::new);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto[] findByCity(String city) {
        Person[] persons = repository.getByAddress_City(city);
        return modelMapper.map(persons, PersonDto[].class);
    }

    @Override
    public PersonDto[] findByAges(int ageFrom, int ageTo) {
        LocalDate dateFrom = LocalDate.now().minusYears(ageTo);
        LocalDate dateTo = LocalDate.now().minusYears(ageFrom);
        Person[] persons = repository.getByBirthDateBetween(dateFrom, dateTo);
        return modelMapper.map(persons, PersonDto[].class);
    }

    @Override
    public PersonDto[] findByName(String name) {
        Person[] persons = repository.getByName(name);
        return modelMapper.map(persons, PersonDto[].class);
    }

    @Override
    @Transactional
    public PersonDto updateName(int id, String name) {
        Person person = repository.findById(id).orElseThrow(PersonNotFoundException::new);
        person.setName(name);
        repository.save(modelMapper.map(person, Person.class));
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto updateAddresses(int id, AddressDto address) {
        Person person = repository.findById(id).orElseThrow(PersonNotFoundException::new);
        person.setAddress(modelMapper.map(address, Address.class));
        repository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public Iterable<CityPopulationDto> getCityPopulation() {
        return null;
    }

    @Override
    @Transactional
    public PersonDto deletePerson(int id) {
        Person person = repository.findById(id).orElseThrow(PersonNotFoundException::new);
        repository.delete(person);
        return modelMapper.map(person, PersonDto.class);
    }
}
