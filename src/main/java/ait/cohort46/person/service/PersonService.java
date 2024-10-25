package ait.cohort46.person.service;

import ait.cohort46.person.dto.AddressDto;
import ait.cohort46.person.dto.CityPopulationDto;
import ait.cohort46.person.dto.PersonDto;

public interface PersonService {
    Boolean addPerson(PersonDto person);
    PersonDto findPerson(int id);
    PersonDto[] findByCity(String city);
    PersonDto[] findByAges(int ageFrom, int ageTo);
    PersonDto[] findByName(String name);
    PersonDto updateName(int id, String name);
    PersonDto updateAddresses(int id, AddressDto address);
    Iterable<CityPopulationDto> getCityPopulation();
    PersonDto deletePerson(int id);
}
